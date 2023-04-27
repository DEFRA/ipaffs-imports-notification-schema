package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class IsoOffsetDateTimeSerializer extends JsonSerializer<LocalDateTime> {

  @Override
  public void serialize(
      LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider provider)
      throws IOException {

    jsonGenerator.writeString(
        DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(localDateTime.atOffset(ZoneOffset.UTC)));
  }
}
