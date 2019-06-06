package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static java.time.format.DateTimeFormatter.ISO_DATE_TIME;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDateTime;

public class IsoDateTimeDeserializer extends JsonDeserializer<LocalDateTime> {

  @Override
  public LocalDateTime deserialize(
      JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {

    return LocalDateTime.parse(jsonParser.getText(), ISO_DATE_TIME);
  }
}
