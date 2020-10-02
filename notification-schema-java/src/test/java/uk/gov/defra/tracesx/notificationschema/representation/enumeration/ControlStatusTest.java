package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ControlStatusTest {
  private final static String COMPLETED_STRING = "COMPLETED";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ControlStatus.COMPLETED.toString();

    assertEquals(enumResult, COMPLETED_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ControlStatus.COMPLETED.getValue();

    assertEquals(enumResult, COMPLETED_STRING);
  }
}