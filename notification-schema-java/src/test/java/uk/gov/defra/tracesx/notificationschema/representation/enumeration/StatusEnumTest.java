package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class StatusEnumTest {
  private final static String AMEND_STRING = "AMEND";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = StatusEnum.AMEND.toString();

    assertEquals(enumResult, AMEND_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = StatusEnum.AMEND.getValue();

    assertEquals(enumResult, AMEND_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    StatusEnum enumResult = StatusEnum.fromValue(AMEND_STRING);

    assertEquals(enumResult, StatusEnum.AMEND);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    StatusEnum enumResult = StatusEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
