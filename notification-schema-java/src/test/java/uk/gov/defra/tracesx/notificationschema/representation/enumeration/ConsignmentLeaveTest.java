package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ConsignmentLeaveTest {
  private final static String YES_STRING = "YES";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ConsignmentLeave.YES.toString();

    assertEquals(enumResult, YES_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ConsignmentLeave.YES.getValue();

    assertEquals(enumResult, YES_STRING);
  }
}