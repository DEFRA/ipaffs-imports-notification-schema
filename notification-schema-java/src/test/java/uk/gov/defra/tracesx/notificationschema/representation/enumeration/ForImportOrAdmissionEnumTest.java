package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class ForImportOrAdmissionEnumTest {
  private final static String DEFINITIVE_IMPORT_STRING = "Definitive import";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ForImportOrAdmissionEnum.DEFINITIVE_IMPORT.toString();

    assertEquals(enumResult, DEFINITIVE_IMPORT_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ForImportOrAdmissionEnum.DEFINITIVE_IMPORT.getValue();

    assertEquals(enumResult, DEFINITIVE_IMPORT_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    ForImportOrAdmissionEnum enumResult = ForImportOrAdmissionEnum.fromValue(DEFINITIVE_IMPORT_STRING);

    assertEquals(enumResult, ForImportOrAdmissionEnum.DEFINITIVE_IMPORT);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    ForImportOrAdmissionEnum enumResult = ForImportOrAdmissionEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
