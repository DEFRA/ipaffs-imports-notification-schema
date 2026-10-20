package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static java.time.format.DateTimeFormatter.ISO_OFFSET_DATE_TIME;

import java.time.LocalDateTime;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Jackson 3 version of {@link IsoOffsetDateTimeDeserializer}, reading the same format.
 */
public class IsoOffsetDateTimeValueDeserializer extends ValueDeserializer<LocalDateTime> {

  @Override
  public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext context) {

    return LocalDateTime.parse(jsonParser.getString(), ISO_OFFSET_DATE_TIME);
  }
}
