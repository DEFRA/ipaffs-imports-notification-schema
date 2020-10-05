package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class ControlStatusTest {
  private final static String COMPLETED_STRING = "COMPLETED";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    ControlStatus enumResult = ControlStatus.fromValue(COMPLETED_STRING);

    assertEquals(enumResult, ControlStatus.COMPLETED);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    ControlStatus enumResult = ControlStatus.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
