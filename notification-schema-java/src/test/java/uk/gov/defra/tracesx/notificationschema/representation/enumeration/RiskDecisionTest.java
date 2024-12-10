package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RiskDecisionTest {

  private final static String INVALID_STRING = "Invalid";
  private final static String REQUIRED = "REQUIRED";

  @Test
  void givenAValidEnumValue_ReturnStringValue_WhenToStringCalled() {
    String enumResult = RiskDecision.REQUIRED.toString();

    assertThat(enumResult).isEqualTo(REQUIRED);
  }

  @Test
  void givenAValidEnumValue_ReturnValue_WhenGetValueCalled() {
    String enumResult = RiskDecision.REQUIRED.getValue();

    assertThat(enumResult).isEqualTo(REQUIRED);
  }

  @Test
  void givenAValidValue_ReturnEnumValue_whenFromValueCalled() {
    RiskDecision enumResult = RiskDecision.fromValue(REQUIRED);

    assertThat(enumResult).isEqualTo(RiskDecision.REQUIRED);
  }

  @Test
  void givenAnInvalidValue_ReturnNull_whenFromValueCalled() {
    RiskDecision enumResult = RiskDecision.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
