package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class DefinitiveImportPurposeEnumTest {
  private final static String SLAUGHTER_STRING = "slaughter";

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
}