package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

 class CheckStatusTest {

  private final static String TO_DO_STRING = "To do";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = CheckStatus.TO_DO.toString();

    assertThat(enumResult).isEqualTo(TO_DO_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = CheckStatus.TO_DO.getValue();

    assertThat(enumResult).isEqualTo(TO_DO_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    CheckStatus enumResult = CheckStatus.fromValue(TO_DO_STRING);

    assertThat(enumResult).isEqualTo(CheckStatus.TO_DO);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    CheckStatus enumResult = CheckStatus.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
