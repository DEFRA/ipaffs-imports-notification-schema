package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import tools.jackson.core.JsonGenerator;
import tools.jackson.databind.SerializationContext;
import tools.jackson.databind.ValueSerializer;

/**
 * Jackson 3 version of {@link IsoOffsetDateTimeSerializer}, writing the same format.
 */
public class IsoOffsetDateTimeValueSerializer extends ValueSerializer<LocalDateTime> {

  @Override
  public void serialize(
      LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializationContext context) {

    jsonGenerator.writeString(
        DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(localDateTime.atOffset(ZoneOffset.UTC)));
  }
}
