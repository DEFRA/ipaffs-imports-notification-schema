package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PurposeGroupEnumTest {
  private final static String FOR_IMPORT_STRING = "For Import";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = PurposeGroupEnum.IMPORT.toString();

    assertThat(enumResult).isEqualTo(FOR_IMPORT_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = PurposeGroupEnum.IMPORT.getValue();

    assertThat(enumResult).isEqualTo(FOR_IMPORT_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    PurposeGroupEnum enumResult = PurposeGroupEnum.fromValue(FOR_IMPORT_STRING);

    assertThat(enumResult).isEqualTo(PurposeGroupEnum.IMPORT);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    PurposeGroupEnum enumResult = PurposeGroupEnum.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
