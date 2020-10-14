package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class CheckStatusTest {

  private final static String TO_DO_STRING = "To do";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = CheckStatus.TO_DO.toString();

    assertEquals(enumResult, TO_DO_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = CheckStatus.TO_DO.getValue();

    assertEquals(enumResult, TO_DO_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    CheckStatus enumResult = CheckStatus.fromValue(TO_DO_STRING);

    assertEquals(enumResult, CheckStatus.TO_DO);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    CheckStatus enumResult = CheckStatus.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
