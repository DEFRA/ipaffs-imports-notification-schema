package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class NotAcceptableActionEnumTest {
  private final static String DESTRUCTION_STRING = "destruction";

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
}