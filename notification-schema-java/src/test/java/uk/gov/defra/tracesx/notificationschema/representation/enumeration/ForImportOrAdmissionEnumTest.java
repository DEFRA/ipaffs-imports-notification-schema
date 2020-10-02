package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ForImportOrAdmissionEnumTest {
  private final static String DEFINITIVE_IMPORT_STRING = "Definitive import";

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
}