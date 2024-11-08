package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;


@ExtendWith(MockitoExtension.class)
class IsNonNegativeIntegerKeyDataPairValidatorTest {

  @Mock
  private IsNonNegativeIntegerKeyDataPair mockKeyDataPair;

  private IsNonNegativeIntegerKeyDataPairValidator validator;
  private List<ComplementParameterSetKeyDataPair> keyDataPairList;

  @BeforeEach
  void setUp() {
    validator = new IsNonNegativeIntegerKeyDataPairValidator();
    when(mockKeyDataPair.field()).thenReturn("number_package");
    keyDataPairList = new ArrayList<>();
    validator.initialize(mockKeyDataPair);
  }

  @Test
  void testKeyDataPairIsInValidIfObjectPassedIsNull() {
    assertThat(validator.isValid(null, null)).isFalse();
  }

  @Test
  void testNumberPackageValidationFailsIfNoValueIsProvided() {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("number_package");
    pair.setData("");
    keyDataPairList.add(pair);

    assertThat(validator.isValid(keyDataPairList, null)).isFalse();
  }

  @ParameterizedTest
  @CsvSource({
      " ,                           false",  // no value
      "1,                           true",   // should pass
      "-1,                          false", //not positive
      "oiiwr,                       false", //not an int
      "332840984904824029348904820, false"  //out of range
  })
  void NumberPackageValidation(String numberPackage, boolean expectedResult) {
    ComplementParameterSetKeyDataPair pair = new ComplementParameterSetKeyDataPair();
    pair.setKey("number_package");
    pair.setData(numberPackage);
    keyDataPairList.add(pair);
    boolean result = validator.isValid(keyDataPairList, null);

    assertThat(expectedResult).isEqualTo(result);
  }

}
