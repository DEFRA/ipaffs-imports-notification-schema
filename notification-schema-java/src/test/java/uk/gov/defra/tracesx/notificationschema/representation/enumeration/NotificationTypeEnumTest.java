package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class NotificationTypeEnumTest {
  private final static String CED_STRING = "CED";

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
}