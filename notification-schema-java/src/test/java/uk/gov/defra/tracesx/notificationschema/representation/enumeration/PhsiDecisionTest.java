package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class PhsiDecisionTest {
  private final static String REQUIRED_STRING = "REQUIRED";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = PhsiDecision.REQUIRED.toString();

    assertEquals(enumResult, REQUIRED_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = PhsiDecision.REQUIRED.getValue();

    assertEquals(enumResult, REQUIRED_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    PhsiDecision enumResult = PhsiDecision.fromValue(REQUIRED_STRING);

    assertEquals(enumResult, PhsiDecision.REQUIRED);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    PhsiDecision enumResult = PhsiDecision.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
