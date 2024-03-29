package uk.gov.defra.tracesx.notificationschema.representation.serialisation;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.fasterxml.jackson.core.JsonGenerator;
import java.io.IOException;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class IsoDateSerializerTest {

  private IsoDateSerializer isoDateSerializer = new IsoDateSerializer();

  @Mock
  JsonGenerator jsonGenerator;

  @Test
  public void givenAValidLocalDate_whenSerializerCalled_expectMethodCalledWithDateAsString()
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
