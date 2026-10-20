package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Jackson 3 version of {@link IsoTimeSerializer}, writing the same format.
 */
public class IsoTimeValueSerializer extends ValueSerializer<LocalTime> {

  @Override
  public void serialize(
      LocalTime time, JsonGenerator jsonGenerator, SerializationContext context) {

    jsonGenerator.writeString(DateTimeFormatter.ISO_TIME.format(time));
  }
}
