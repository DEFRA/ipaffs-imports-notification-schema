package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.core.JsonParser;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IsoDateDeserializerTest {

  private final IsoDateDeserializer isoDateDeserializer = new IsoDateDeserializer();

  @Mock
  private JsonParser jsonParser;

  @Test
  void givenAValidDateString_whenDeserializerCalled_expectLocalDate() throws IOException {
    // given
    when(jsonParser.getText()).thenReturn("2020-08-04");

    // when
    LocalDate result = isoDateDeserializer.deserialize(jsonParser, null);

    // then
    LocalDate expected = LocalDate.of(2020, 8, 4);
    assertThat(result).isEqualTo(expected);
  }
}
