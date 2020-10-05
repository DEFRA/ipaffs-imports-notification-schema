package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class NotificationTypeEnumTest {
  private final static String CED_STRING = "CED";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = NotificationTypeEnum.CED.toString();

    assertEquals(enumResult, CED_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = NotificationTypeEnum.CED.getValue();

    assertEquals(enumResult, CED_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    NotificationTypeEnum enumResult = NotificationTypeEnum.fromValue(CED_STRING);

    assertEquals(enumResult, NotificationTypeEnum.CED);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    NotificationTypeEnum enumResult = NotificationTypeEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
