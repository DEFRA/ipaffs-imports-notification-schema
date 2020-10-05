package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class ResultTest {
  private final static String DEROGATION_STRING = "Derogation";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = Result.DEROGATION.toString();

    assertEquals(enumResult, DEROGATION_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = Result.DEROGATION.getValue();

    assertEquals(enumResult, DEROGATION_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    Result enumResult = Result.fromValue(DEROGATION_STRING);

    assertEquals(enumResult, Result.DEROGATION);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    Result enumResult = Result.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
