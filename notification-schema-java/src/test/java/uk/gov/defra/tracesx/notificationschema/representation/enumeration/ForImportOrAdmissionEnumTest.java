package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ForImportOrAdmissionEnumTest {
  private final static String DEFINITIVE_IMPORT_STRING = "Definitive import";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ForImportOrAdmissionEnum.DEFINITIVE_IMPORT.toString();

    assertThat(enumResult).isEqualTo(DEFINITIVE_IMPORT_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ForImportOrAdmissionEnum.DEFINITIVE_IMPORT.getValue();

    assertThat(enumResult).isEqualTo(DEFINITIVE_IMPORT_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    ForImportOrAdmissionEnum enumResult = ForImportOrAdmissionEnum.fromValue(DEFINITIVE_IMPORT_STRING);

    assertThat(enumResult).isEqualTo(ForImportOrAdmissionEnum.DEFINITIVE_IMPORT);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    ForImportOrAdmissionEnum enumResult = ForImportOrAdmissionEnum.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
