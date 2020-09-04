package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class ConsignmentLeaveTest {
  private final static String YES_STRING = "YES";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    ConsignmentLeave enumResult = ConsignmentLeave.fromValue(YES_STRING);

    assertEquals(enumResult, ConsignmentLeave.YES);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    ConsignmentLeave enumResult = ConsignmentLeave.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
