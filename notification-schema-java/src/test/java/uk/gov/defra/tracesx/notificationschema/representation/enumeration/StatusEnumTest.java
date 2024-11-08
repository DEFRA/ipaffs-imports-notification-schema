package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StatusEnumTest {
  private final static String AMEND_STRING = "AMEND";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = StatusEnum.AMEND.toString();

    assertThat(enumResult).isEqualTo(AMEND_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = StatusEnum.AMEND.getValue();

    assertThat(enumResult).isEqualTo(AMEND_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    StatusEnum enumResult = StatusEnum.fromValue(AMEND_STRING);

    assertThat(enumResult).isEqualTo(StatusEnum.AMEND);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    StatusEnum enumResult = StatusEnum.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }

  @Test
  void givenValidValuesUnderToProcessStatus_whenFromValueCalled_shouldReturnEnumValue() {
    StatusEnum enumResult = StatusEnum.fromValue("SUBMITTED,IN_PROGRESS,MODIFY");
    assertThat(enumResult).isEqualTo(StatusEnum.TO_PROCESS);
  }
}
