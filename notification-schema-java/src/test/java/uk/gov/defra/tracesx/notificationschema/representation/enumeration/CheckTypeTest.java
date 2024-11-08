package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

 class CheckTypeTest {

  private final static String PHSI_DOCUMENT_STRING = "PHSI_DOCUMENT";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = CheckType.PHSI_DOCUMENT.toString();

    assertThat(enumResult).isEqualTo(PHSI_DOCUMENT_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = CheckType.PHSI_DOCUMENT.getValue();

    assertThat(enumResult).isEqualTo(PHSI_DOCUMENT_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    CheckType enumResult = CheckType.fromValue(PHSI_DOCUMENT_STRING);

    assertThat(enumResult).isEqualTo(CheckType.PHSI_DOCUMENT);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    CheckType enumResult = CheckType.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
