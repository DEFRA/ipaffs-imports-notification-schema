package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ChedppIsPositiveDoubleKeyDataPairValidatorTest {

  private static final String FIELD = "field";
  private final ChedppIsPositiveDoubleKeyDataPairValidator testSubject = new ChedppIsPositiveDoubleKeyDataPairValidator();
  @Mock
  private ChedppIsPositiveDoubleKeyDataPair keyDataPair;

  @Test
  void initializeValidator_ReturnsNewInstance() {
    when(keyDataPair.field()).thenReturn(FIELD);
    assertThat(testSubject.initializeValidator(keyDataPair)).usingRecursiveComparison()
        .isEqualTo(new IsPositiveDoubleKeyDataPairValidation(FIELD));
  }
}
