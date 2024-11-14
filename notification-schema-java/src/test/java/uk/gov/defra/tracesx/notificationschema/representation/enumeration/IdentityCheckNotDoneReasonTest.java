package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IdentityCheckNotDoneReasonTest {

  private final static String REDUCED_CHECKS_REGIME_STRING = "Reduced checks regime";
  private final static String NOT_REQUIRED_STRING = "Not required";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = IdentityCheckNotDoneReason.REDUCED_CHECKS_REGIME.toString();

    assertThat(enumResult).isEqualTo(REDUCED_CHECKS_REGIME_STRING);
  }

  @Test
  void givenAValidEnumValue_notRequired_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = IdentityCheckNotDoneReason.NOT_REQUIRED.toString();

    assertThat(enumResult).isEqualTo(NOT_REQUIRED_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = IdentityCheckNotDoneReason.NOT_REQUIRED.getValue();

    assertThat(enumResult).isEqualTo(NOT_REQUIRED_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    IdentityCheckNotDoneReason enumResult = IdentityCheckNotDoneReason.fromValue(
        NOT_REQUIRED_STRING);

    assertThat(enumResult).isEqualTo(IdentityCheckNotDoneReason.NOT_REQUIRED);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    IdentityCheckNotDoneReason enumResult = IdentityCheckNotDoneReason.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
