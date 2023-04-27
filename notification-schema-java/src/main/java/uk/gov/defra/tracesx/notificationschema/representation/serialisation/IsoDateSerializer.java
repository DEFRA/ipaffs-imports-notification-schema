package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class IsoDateSerializer extends JsonSerializer<LocalDate> {

  @Override
  public void serialize(LocalDate date, JsonGenerator jsonGenerator, SerializerProvider provider)
      throws IOException {

    jsonGenerator.writeString(DateTimeFormatter.ISO_DATE.format(date));
  }
}
