package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class EconomicOperatorStatusTest {
  private final static String SUSPENDED_STRING = "suspended";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = EconomicOperatorStatus.SUSPENDED.toString();

    assertThat(enumResult).isEqualTo(SUSPENDED_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = EconomicOperatorStatus.SUSPENDED.getValue();

    assertThat(enumResult).isEqualTo(SUSPENDED_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    EconomicOperatorStatus enumResult = EconomicOperatorStatus.fromValue(SUSPENDED_STRING);

    assertThat(enumResult).isEqualTo(EconomicOperatorStatus.SUSPENDED);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    EconomicOperatorStatus enumResult = EconomicOperatorStatus.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
