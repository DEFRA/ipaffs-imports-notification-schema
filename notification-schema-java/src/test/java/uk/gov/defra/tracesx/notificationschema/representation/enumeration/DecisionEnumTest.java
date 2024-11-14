package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DecisionEnumTest {
  private final static String NON_ACCEPTABLE_STRING = "Non Acceptable";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = DecisionEnum.NON_ACCEPTABLE.toString();

    assertThat(enumResult).isEqualTo(NON_ACCEPTABLE_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = DecisionEnum.NON_ACCEPTABLE.getValue();

    assertThat(enumResult).isEqualTo(NON_ACCEPTABLE_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    DecisionEnum enumResult = DecisionEnum.fromValue(NON_ACCEPTABLE_STRING);

    assertThat(enumResult).isEqualTo(DecisionEnum.NON_ACCEPTABLE);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    DecisionEnum enumResult = DecisionEnum.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
