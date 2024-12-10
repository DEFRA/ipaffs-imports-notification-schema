package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EconomicOperatorTypeTest {
  private final static String CHARITY_STRING = "charity";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = EconomicOperatorType.CHARITY.toString();

    assertThat(enumResult).isEqualTo(CHARITY_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = EconomicOperatorType.CHARITY.getValue();

    assertThat(enumResult).isEqualTo(CHARITY_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    EconomicOperatorType enumResult = EconomicOperatorType.fromValue(CHARITY_STRING);

    assertThat(enumResult).isEqualTo(EconomicOperatorType.CHARITY);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    EconomicOperatorType enumResult = EconomicOperatorType.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
