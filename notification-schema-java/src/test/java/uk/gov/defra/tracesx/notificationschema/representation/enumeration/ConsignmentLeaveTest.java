package uk.gov.defra.tracesx.notificationschema.representation.enumeration;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ConsignmentLeaveTest {
  private final static String YES_STRING = "YES";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ConsignmentLeave.YES.toString();

    assertThat(enumResult).isEqualTo(YES_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ConsignmentLeave.YES.getValue();

    assertThat(enumResult).isEqualTo(YES_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    ConsignmentLeave enumResult = ConsignmentLeave.fromValue(YES_STRING);

    assertThat(enumResult).isEqualTo(ConsignmentLeave.YES);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    ConsignmentLeave enumResult = ConsignmentLeave.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
