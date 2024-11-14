package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IsoTimeDeserializerTest {

  private final IsoTimeDeserializer isoTimeDeserializer = new IsoTimeDeserializer();

  @Mock
  private JsonParser jsonParser;

  @Test
  void givenAValidTimeString_whenDeserializerCalled_expectLocalTime() throws IOException {
    // given
    when(jsonParser.getText()).thenReturn("15:45:37.029947Z");

    // when
    LocalTime result = isoTimeDeserializer.deserialize(jsonParser, null);

    // then
    LocalTime expectedTime = LocalTime.of(15, 45, 37, 29947000);
    assertThat(result).isEqualTo(expectedTime);
  }
}
