package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static java.time.format.DateTimeFormatter.ISO_DATE;

import java.time.LocalDate;
import tools.jackson.core.JsonParser;
import tools.jackson.databind.DeserializationContext;
import tools.jackson.databind.ValueDeserializer;

/**
 * Jackson 3 version of {@link IsoDateDeserializer}, reading the same format.
 */
public class IsoDateValueDeserializer extends ValueDeserializer<LocalDate> {

  @Override
  public LocalDate deserialize(JsonParser jsonParser, DeserializationContext context) {

    return LocalDate.parse(jsonParser.getString(), ISO_DATE);
  }
}
