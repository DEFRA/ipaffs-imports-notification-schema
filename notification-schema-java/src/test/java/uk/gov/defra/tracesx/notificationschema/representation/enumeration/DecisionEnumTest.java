package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class DecisionEnumTest {
  private final static String NON_ACCEPTABLE_STRING = "Non Acceptable";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = DecisionEnum.NON_ACCEPTABLE.toString();

    assertEquals(enumResult, NON_ACCEPTABLE_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = DecisionEnum.NON_ACCEPTABLE.getValue();

    assertEquals(enumResult, NON_ACCEPTABLE_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    DecisionEnum enumResult = DecisionEnum.fromValue(NON_ACCEPTABLE_STRING);

    assertEquals(enumResult, DecisionEnum.NON_ACCEPTABLE);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    DecisionEnum enumResult = DecisionEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
