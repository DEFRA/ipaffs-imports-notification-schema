package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class PhsiClassificationTest {
  private final static String MANDATORY_STRING = "Mandatory";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = PhsiClassification.MANDATORY.toString();

    assertEquals(enumResult, MANDATORY_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = PhsiClassification.MANDATORY.getValue();

    assertEquals(enumResult, MANDATORY_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    PhsiClassification enumResult = PhsiClassification.fromValue(MANDATORY_STRING);

    assertEquals(enumResult, PhsiClassification.MANDATORY);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    PhsiDecision enumResult = PhsiDecision.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
