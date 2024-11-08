package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class HmiDecisionTest {
  private final static String REQUIRED_STRING = "REQUIRED";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = HmiDecision.REQUIRED.toString();

    assertThat(enumResult).isEqualTo(REQUIRED_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = HmiDecision.REQUIRED.getValue();

    assertThat(enumResult).isEqualTo(REQUIRED_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    HmiDecision enumResult = HmiDecision.fromValue(REQUIRED_STRING);

    assertThat(enumResult).isEqualTo(HmiDecision.REQUIRED);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    HmiDecision enumResult = HmiDecision.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
