package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static java.time.format.DateTimeFormatter.ISO_TIME;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalTime;

public class IsoTimeDeserializer extends JsonDeserializer<LocalTime> {

  @Override
  public LocalTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
      throws IOException {

    return LocalTime.parse(jsonParser.getText(), ISO_TIME);
  }
}
