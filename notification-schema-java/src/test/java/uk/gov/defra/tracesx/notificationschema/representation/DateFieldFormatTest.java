package uk.gov.defra.tracesx.notificationschema.representation;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import tools.jackson.databind.json.JsonMapper;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateSerializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateTimeSerializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeSerializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoTimeSerializer;

/**
 * Pins the JSON format of every date and time field that has a custom serializer, and that the
 * same JSON reads back to the same value, with both Jackson 2 and Jackson 3. Fields are found by
 * scanning this package, so a new annotated field is covered automatically.
 */
class DateFieldFormatTest {

  private static final String PACKAGE = Notification.class.getPackageName();

  // Sample values, and the JSON string each serializer must write for them
  private static final Map<Class<?>, List<Sample>> SAMPLES = Map.of(
      IsoDateSerializer.class, List.of(
          new Sample(LocalDate.of(2026, 10, 21), "2026-10-21")),
      IsoTimeSerializer.class, List.of(
          new Sample(LocalTime.of(14, 5), "14:05:00"),
          new Sample(LocalTime.of(15, 45, 37, 29_947_000), "15:45:37.029947")),
      IsoDateTimeSerializer.class, List.of(
          new Sample(LocalDateTime.of(2026, 10, 21, 13, 0), "2026-10-21T13:00:00"),
          new Sample(LocalDateTime.of(2020, 8, 4, 15, 45, 37, 29_947_000),
              "2020-08-04T15:45:37.029947")),
      IsoOffsetDateTimeSerializer.class, List.of(
          new Sample(LocalDateTime.of(2026, 10, 21, 13, 0), "2026-10-21T13:00:00Z"),
          new Sample(LocalDateTime.of(2020, 8, 4, 15, 45, 37, 29_947_000),
              "2020-08-04T15:45:37.029947Z")));

  private final ObjectMapper objectMapper = new ObjectMapper();
  private final JsonMapper jsonMapper = JsonMapper.builder().build();

  @Test
  void findsTheAnnotatedDateFields() {
    assertThat(annotatedFields()).hasSize(33);
  }

  @ParameterizedTest(name = "{0}.{1} = {3}")
  @MethodSource("dateFieldSamples")
  void writesAndReadsTheDateFormat(
      String className, String fieldName, Object value, String json) throws Exception {
    Field field = Class.forName(PACKAGE + "." + className).getDeclaredField(fieldName);
    field.setAccessible(true);
    Object instance = newInstance(field.getDeclaringClass());
    field.set(instance, value);

    JsonNode written = objectMapper.valueToTree(instance);
    assertThat(written.get(fieldName).isTextual()).isTrue();
    assertThat(written.get(fieldName).textValue()).isEqualTo(json);

    Object read = objectMapper.readValue(
        objectMapper.writeValueAsString(Map.of(fieldName, json)), field.getDeclaringClass());
    assertThat(field.get(read)).isEqualTo(value);
  }

  @ParameterizedTest(name = "{0}.{1} = {3}")
  @MethodSource("dateFieldSamples")
  void jackson3WritesAndReadsTheSameDateFormat(
      String className, String fieldName, Object value, String json) throws Exception {
    Field field = Class.forName(PACKAGE + "." + className).getDeclaredField(fieldName);
    field.setAccessible(true);
    Object instance = newInstance(field.getDeclaringClass());
    field.set(instance, value);

    JsonNode written = objectMapper.readTree(jsonMapper.writeValueAsString(instance));
    assertThat(written.get(fieldName).isTextual()).isTrue();
    assertThat(written.get(fieldName).textValue()).isEqualTo(json);

    Object read = jsonMapper.readValue(
        jsonMapper.writeValueAsString(Map.of(fieldName, json)), field.getDeclaringClass());
    assertThat(field.get(read)).isEqualTo(value);
  }

  @Test
  void everyDateFieldHasTheJackson3Annotations() {
    assertThat(annotatedFields()).allSatisfy(field -> {
      var serialize = field.getAnnotation(tools.jackson.databind.annotation.JsonSerialize.class);
      var deserialize =
          field.getAnnotation(tools.jackson.databind.annotation.JsonDeserialize.class);

      assertThat(serialize).as(field.toString()).isNotNull();
      assertThat(deserialize).as(field.toString()).isNotNull();
      assertThat(serialize.using().getSimpleName()).as(field.toString()).isEqualTo(
          field.getAnnotation(JsonSerialize.class).using().getSimpleName()
              .replace("Serializer", "ValueSerializer"));
      assertThat(deserialize.using().getSimpleName()).as(field.toString()).isEqualTo(
          field.getAnnotation(JsonDeserialize.class).using().getSimpleName()
              .replace("Deserializer", "ValueDeserializer"));
    });
  }

  // Lombok's @Jacksonized builders, which lombok.config generates for Jackson 2 and 3
  @Test
  void jackson3ReadsTheBuilderClasses() {
    List<Class<?>> builderClasses = representationClasses().stream()
        .filter(type -> type.isAnnotationPresent(JsonDeserialize.class)
            && type.getAnnotation(JsonDeserialize.class).builder() != Void.class)
        .toList();

    assertThat(builderClasses).isNotEmpty().allSatisfy(type ->
        assertThat(jsonMapper.readValue("{}", type)).isEqualTo(newInstance(type)));
  }

  static Stream<Arguments> dateFieldSamples() {
    return annotatedFields().stream()
        .flatMap(field -> SAMPLES.get(field.getAnnotation(JsonSerialize.class).using()).stream()
            .map(sample -> Arguments.of(field.getDeclaringClass().getSimpleName(),
                field.getName(), sample.value(), sample.json())));
  }

  private static List<Field> annotatedFields() {
    return representationClasses().stream()
        .flatMap(type -> Arrays.stream(type.getDeclaredFields()))
        .filter(field -> field.isAnnotationPresent(JsonSerialize.class))
        .toList();
  }

  private static List<Class<?>> representationClasses() {
    try {
      Path directory =
          Path.of(Notification.class.getResource("Notification.class").toURI()).getParent();
      try (Stream<Path> files = Files.list(directory)) {
        return files
            .map(file -> file.getFileName().toString())
            .filter(name -> name.endsWith(".class") && !name.contains("$"))
            .<Class<?>>map(name -> loadClass(PACKAGE + "." + name.replace(".class", "")))
            .toList();
      }
    } catch (IOException | URISyntaxException exception) {
      throw new IllegalStateException(exception);
    }
  }

  private static Class<?> loadClass(String name) {
    try {
      return Class.forName(name);
    } catch (ClassNotFoundException exception) {
      throw new IllegalStateException(exception);
    }
  }

  private static Object newInstance(Class<?> type) throws ReflectiveOperationException {
    Object builder = type.getMethod("builder").invoke(null);
    return builder.getClass().getMethod("build").invoke(builder);
  }

  private record Sample(Object value, String json) {
  }
}
