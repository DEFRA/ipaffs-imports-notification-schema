package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class PurposeGroupEnumTest {
  private final static String FOR_IMPORT_STRING = "For Import";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    PurposeGroupEnum enumResult = PurposeGroupEnum.fromValue(FOR_IMPORT_STRING);

    assertEquals(enumResult, PurposeGroupEnum.IMPORT);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    PurposeGroupEnum enumResult = PurposeGroupEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
