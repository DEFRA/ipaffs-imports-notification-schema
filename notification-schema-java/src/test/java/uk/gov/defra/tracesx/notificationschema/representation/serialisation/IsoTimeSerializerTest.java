package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IsoTimeSerializerTest {

  private final IsoTimeSerializer isoTimeSerializer = new IsoTimeSerializer();

  @Mock
  JsonGenerator jsonGenerator;

  @Test
  void givenAValidLocalTime_whenSerializerCalled_expectMethodCalledWithTimeAsString()
      throws IOException {
    // given
    LocalTime localTime = LocalTime.of(15, 45, 37, 29947000);

    // when
    isoTimeSerializer.serialize(localTime, jsonGenerator, null);

    // then
    String expected = "15:45:37.029947";
    verify(jsonGenerator, times(1)).writeString(expected);
  }
}
