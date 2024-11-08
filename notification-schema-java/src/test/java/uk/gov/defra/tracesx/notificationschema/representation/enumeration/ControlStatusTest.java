package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ControlStatusTest {
  private final static String COMPLETED_STRING = "COMPLETED";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ControlStatus.COMPLETED.toString();

    assertThat(enumResult).isEqualTo(COMPLETED_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ControlStatus.COMPLETED.getValue();

    assertThat(enumResult).isEqualTo(COMPLETED_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    ControlStatus enumResult = ControlStatus.fromValue(COMPLETED_STRING);

    assertThat(enumResult).isEqualTo(ControlStatus.COMPLETED);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    ControlStatus enumResult = ControlStatus.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
