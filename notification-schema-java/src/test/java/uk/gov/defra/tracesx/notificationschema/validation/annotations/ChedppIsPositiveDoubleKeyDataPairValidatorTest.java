package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ChedppIsPositiveDoubleKeyDataPairValidatorTest {

  private static final String FIELD = "field";
  private final ChedppIsPositiveDoubleKeyDataPairValidator testSubject = new ChedppIsPositiveDoubleKeyDataPairValidator();
  @Mock
  private ChedppIsPositiveDoubleKeyDataPair keyDataPair;

  @Test
  public void initializeValidator_ReturnsNewInstance() {
    when(keyDataPair.field()).thenReturn(FIELD);
    assertThat(testSubject.initializeValidator(keyDataPair)).isEqualToComparingFieldByField(
        new IsPositiveDoubleKeyDataPairValidation(FIELD));
  }
}