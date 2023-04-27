package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IsoDateTimeDeserializerTest {

  private IsoDateTimeDeserializer isoDateTimeDeserializer = new IsoDateTimeDeserializer();

  @Mock
  private JsonParser jsonParser;

  @Test
  public void givenAValidDateTimeString_whenDeserializerCalled_expectLocalDate() throws IOException {
    // given
    when(jsonParser.getText()).thenReturn("2020-08-04T15:45:37.029947Z");

    // when
    LocalDateTime result = isoDateTimeDeserializer.deserialize(jsonParser, null);

    // then
    LocalDate expectedDate = LocalDate.of(2020, 8, 4);
    LocalTime expectedTime = LocalTime.of(15, 45, 37, 29947000);
    assertThat(result.toLocalDate()).isEqualTo(expectedDate);
    assertThat(result.toLocalTime()).isEqualTo(expectedTime);
  }
}
