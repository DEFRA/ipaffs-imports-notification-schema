package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class PurposeGroupEnumTest {
  private final static String FOR_IMPORT_STRING = "For Import";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = PurposeGroupEnum.IMPORT.toString();

    assertEquals(enumResult, FOR_IMPORT_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = PurposeGroupEnum.IMPORT.getValue();

    assertEquals(enumResult, FOR_IMPORT_STRING);
  }
}