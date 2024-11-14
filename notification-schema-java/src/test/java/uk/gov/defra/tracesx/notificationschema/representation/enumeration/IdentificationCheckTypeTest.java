package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IdentificationCheckTypeTest {
  private final static String SEAL_CHECK_STRING = "Seal Check";
  private final static String INVALID_STRING = "Invalid";
  private final static String NOT_DONE_STRING = "Not Done";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = IdentificationCheckType.SEAL_CHECK.toString();

    assertThat(enumResult).isEqualTo(SEAL_CHECK_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = IdentificationCheckType.SEAL_CHECK.getValue();

    assertThat(enumResult).isEqualTo(SEAL_CHECK_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    IdentificationCheckType enumResult = IdentificationCheckType.fromValue(SEAL_CHECK_STRING);

    assertThat(enumResult).isEqualTo(IdentificationCheckType.SEAL_CHECK);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    IdentificationCheckType enumResult = IdentificationCheckType.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }

  @Test
  void shouldReturnNotDoneIdentityCheckType() {
    String enumResult = IdentificationCheckType.NOT_DONE.getValue();

    assertThat(enumResult).isEqualTo(NOT_DONE_STRING);
  }
}
