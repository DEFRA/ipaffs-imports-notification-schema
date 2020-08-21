package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class DefinitiveImportPurposeEnumTest {
  private final static String SLAUGHTER_STRING = "slaughter";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = DefinitiveImportPurposeEnum.SLAUGHTER.toString();

    assertEquals(enumResult, SLAUGHTER_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = DefinitiveImportPurposeEnum.SLAUGHTER.getValue();

    assertEquals(enumResult, SLAUGHTER_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    DefinitiveImportPurposeEnum enumResult = DefinitiveImportPurposeEnum.fromValue(SLAUGHTER_STRING);

    assertEquals(enumResult, DefinitiveImportPurposeEnum.SLAUGHTER);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    DefinitiveImportPurposeEnum enumResult = DefinitiveImportPurposeEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
