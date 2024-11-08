package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ConclusionTest {
  private final static String SATISFACTORY_STRING = "Satisfactory";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = Conclusion.SATISFACTORY.toString();

    assertThat(enumResult).isEqualTo(SATISFACTORY_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = Conclusion.SATISFACTORY.getValue();

    assertThat(enumResult).isEqualTo(SATISFACTORY_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    Conclusion enumResult = Conclusion.fromValue(SATISFACTORY_STRING);

    assertThat(enumResult).isEqualTo(Conclusion.SATISFACTORY);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    Conclusion enumResult = Conclusion.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
