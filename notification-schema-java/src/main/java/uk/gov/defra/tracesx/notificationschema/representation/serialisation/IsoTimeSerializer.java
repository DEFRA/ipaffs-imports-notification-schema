package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class IsoTimeSerializer extends JsonSerializer<LocalTime> {

  @Override
  public void serialize(LocalTime time, JsonGenerator jsonGenerator, SerializerProvider provider)
      throws IOException {

    jsonGenerator.writeString(DateTimeFormatter.ISO_TIME.format(time));
  }
}
