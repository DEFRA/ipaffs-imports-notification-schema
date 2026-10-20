package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Jackson 3 version of {@link IsoDateTimeSerializer}, writing the same format.
 */
public class IsoDateTimeValueSerializer extends ValueSerializer<LocalDateTime> {

  @Override
  public void serialize(
      LocalDateTime date, JsonGenerator jsonGenerator, SerializationContext context) {

    jsonGenerator.writeString(DateTimeFormatter.ISO_DATE_TIME.format(date));
  }
}
