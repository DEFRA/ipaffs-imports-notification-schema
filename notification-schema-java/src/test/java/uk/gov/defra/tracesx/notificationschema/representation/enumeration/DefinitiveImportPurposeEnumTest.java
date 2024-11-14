package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DefinitiveImportPurposeEnumTest {
  private final static String SLAUGHTER_STRING = "slaughter";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = DefinitiveImportPurposeEnum.SLAUGHTER.toString();

    assertThat(enumResult).isEqualTo(SLAUGHTER_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = DefinitiveImportPurposeEnum.SLAUGHTER.getValue();

    assertThat(enumResult).isEqualTo(SLAUGHTER_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    DefinitiveImportPurposeEnum enumResult = DefinitiveImportPurposeEnum.fromValue(SLAUGHTER_STRING);

    assertThat(enumResult).isEqualTo(DefinitiveImportPurposeEnum.SLAUGHTER);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    DefinitiveImportPurposeEnum enumResult = DefinitiveImportPurposeEnum.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
