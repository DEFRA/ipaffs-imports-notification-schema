package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Jackson 3 version of {@link IsoDateSerializer}, writing the same format.
 */
public class IsoDateValueSerializer extends ValueSerializer<LocalDate> {

  @Override
  public void serialize(
      LocalDate date, JsonGenerator jsonGenerator, SerializationContext context) {

    jsonGenerator.writeString(DateTimeFormatter.ISO_DATE.format(date));
  }
}
