package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ExternalSystemTest {
  private final static String TRACESNT_STRING = "TRACESNT";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ExternalSystem.TRACESNT.toString();

    assertEquals(enumResult, TRACESNT_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ExternalSystem.TRACESNT.getValue();

    assertEquals(enumResult, TRACESNT_STRING);
  }
}