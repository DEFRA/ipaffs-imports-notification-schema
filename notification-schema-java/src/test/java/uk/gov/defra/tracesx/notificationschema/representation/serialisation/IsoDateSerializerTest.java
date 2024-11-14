package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class IsoDateSerializerTest {

  private final IsoDateSerializer isoDateSerializer = new IsoDateSerializer();

  @Mock
  JsonGenerator jsonGenerator;

  @Test
  void givenAValidLocalDate_whenSerializerCalled_expectMethodCalledWithDateAsString()
      throws IOException {
    // given
    LocalDate localDate = LocalDate.of(2020, 8, 4);

    // when
    isoDateSerializer.serialize(localDate, jsonGenerator, null);

    // then
    String expected = "2020-08-04";
    verify(jsonGenerator, times(1)).writeString(expected);
  }
}
