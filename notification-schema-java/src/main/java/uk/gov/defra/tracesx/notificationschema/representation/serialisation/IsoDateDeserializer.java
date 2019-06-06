package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static java.time.format.DateTimeFormatter.ISO_DATE;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class IsoDateDeserializer extends JsonDeserializer<LocalDate> {

  @Override
  public LocalDate deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {

    return LocalDate.parse(jsonParser.getText(), ISO_DATE);
  }
}
