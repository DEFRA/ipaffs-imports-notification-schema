package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IsoOffsetDateTimeSerializerTest {

  private final IsoOffsetDateTimeSerializer isoOffsetDateTimeSerializer = new IsoOffsetDateTimeSerializer();

  @Mock
  JsonGenerator jsonGenerator;

  @Test
  void givenAValidLocalDateTime_whenSerializerCalled_expectMethodCalledWithDateTimeAsString()
      throws IOException {
    // given
    LocalDate localDate = LocalDate.of(2020, 8, 4);
    LocalTime localTime = LocalTime.of(15, 45, 37, 29947000);
    LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

    // when
    isoOffsetDateTimeSerializer.serialize(localDateTime, jsonGenerator, null);

    // then
    String expected = "2020-08-04T15:45:37.029947Z";
    verify(jsonGenerator, times(1)).writeString(expected);
  }
}
