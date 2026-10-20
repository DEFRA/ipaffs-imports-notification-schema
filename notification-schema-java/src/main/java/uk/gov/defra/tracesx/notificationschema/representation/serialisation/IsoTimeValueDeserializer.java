package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static java.time.format.DateTimeFormatter.ISO_TIME;

import java.time.LocalTime;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Jackson 3 version of {@link IsoTimeDeserializer}, reading the same format.
 */
public class IsoTimeValueDeserializer extends ValueDeserializer<LocalTime> {

  @Override
  public LocalTime deserialize(JsonParser jsonParser, DeserializationContext context) {

    return LocalTime.parse(jsonParser.getString(), ISO_TIME);
  }
}
