package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class IsPositiveDoubleKeyDataPairValidationTest {
  private IsPositiveDoubleKeyDataPairValidation validator;

  @BeforeEach
  void setup() {
    validator = new IsPositiveDoubleKeyDataPairValidation("quantity");
  }

  @ParameterizedTest
  @CsvSource({
      " ,                           false",
      "1,                           true",
      "-1,                          false",
      "??,                          false",
      "1.5,                         true",
      "0,                           false"
  })
  void shouldValidateData(String quantity, boolean expected) {
    boolean result = validator.isValid(quantity);
    assertThat(result).isEqualTo(expected);
  }
}
