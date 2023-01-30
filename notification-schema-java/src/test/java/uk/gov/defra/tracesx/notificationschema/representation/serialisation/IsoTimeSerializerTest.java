package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fasterxml.jackson.core.JsonGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

@RunWith(MockitoJUnitRunner.class)
public class IsoTimeSerializerTest {

  private IsoTimeSerializer isoTimeSerializer = new IsoTimeSerializer();

  @Mock
  JsonGenerator jsonGenerator;

  @Test
  public void givenAValidLocalTime_whenSerializerCalled_expectMethodCalledWithTimeAsString()
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
