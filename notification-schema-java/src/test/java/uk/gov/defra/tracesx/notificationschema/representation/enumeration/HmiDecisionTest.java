package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class HmiDecisionTest {
  private final static String REQUIRED_STRING = "REQUIRED";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = HmiDecision.REQUIRED.toString();

    assertEquals(enumResult, REQUIRED_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = HmiDecision.REQUIRED.getValue();

    assertEquals(enumResult, REQUIRED_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    HmiDecision enumResult = HmiDecision.fromValue(REQUIRED_STRING);

    assertEquals(enumResult, HmiDecision.REQUIRED);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    HmiDecision enumResult = HmiDecision.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
