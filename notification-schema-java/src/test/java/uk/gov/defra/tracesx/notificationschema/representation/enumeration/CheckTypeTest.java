package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class CheckTypeTest {

  private final static String PHSI_DOCUMENT_STRING = "PHSI_DOCUMENT";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = CheckType.PHSI_DOCUMENT.toString();

    assertEquals(enumResult, PHSI_DOCUMENT_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = CheckType.PHSI_DOCUMENT.getValue();

    assertEquals(enumResult, PHSI_DOCUMENT_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    CheckType enumResult = CheckType.fromValue(PHSI_DOCUMENT_STRING);

    assertEquals(enumResult, CheckType.PHSI_DOCUMENT);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    CheckType enumResult = CheckType.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
