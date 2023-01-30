package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class IsoDateTimeSerializer extends JsonSerializer<LocalDateTime> {

  @Override
  public void serialize(
      LocalDateTime date, JsonGenerator jsonGenerator, SerializerProvider provider)
      throws IOException {

    jsonGenerator.writeString(DateTimeFormatter.ISO_DATE_TIME.format(date));
  }
}
