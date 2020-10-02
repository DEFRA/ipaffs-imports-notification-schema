package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class StatusEnumTest {
  private final static String AMEND_STRING = "AMEND";

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
}