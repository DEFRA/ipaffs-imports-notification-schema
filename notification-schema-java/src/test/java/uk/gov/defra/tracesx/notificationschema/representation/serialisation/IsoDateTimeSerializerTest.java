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
import java.time.LocalDateTime;
import java.time.LocalTime;

@RunWith(MockitoJUnitRunner.class)
public class IsoDateTimeSerializerTest {

  private IsoDateTimeSerializer isoDateTimeSerializer = new IsoDateTimeSerializer();

  @Mock
  JsonGenerator jsonGenerator;

  @Test
  public void givenAValidLocalDateTime_whenSerializerCalled_expectMethodCalledWithDateTimeAsString()
      throws IOException {
    // given
    LocalDate localDate = LocalDate.of(2020, 8, 4);
    LocalTime localTime = LocalTime.of(15, 45, 37, 29947000);
    LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

    // when
    isoDateTimeSerializer.serialize(localDateTime, jsonGenerator, null);

    // then
    String expected = "2020-08-04T15:45:37.029947";
    verify(jsonGenerator, times(1)).writeString(expected);
  }
}
