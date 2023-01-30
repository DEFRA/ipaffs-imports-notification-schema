package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class NotAcceptableActionEnumTest {
  private final static String DESTRUCTION_STRING = "destruction";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = NotAcceptableActionEnum.DESTRUCTION.toString();

    assertEquals(enumResult, DESTRUCTION_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = NotAcceptableActionEnum.DESTRUCTION.getValue();

    assertEquals(enumResult, DESTRUCTION_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    NotAcceptableActionEnum enumResult = NotAcceptableActionEnum.fromValue(DESTRUCTION_STRING);

    assertEquals(enumResult, NotAcceptableActionEnum.DESTRUCTION);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    NotAcceptableActionEnum enumResult = NotAcceptableActionEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
