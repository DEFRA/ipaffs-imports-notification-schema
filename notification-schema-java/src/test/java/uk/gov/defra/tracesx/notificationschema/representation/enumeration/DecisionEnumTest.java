package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class DecisionEnumTest {
  private final static String NON_ACCEPTABLE_STRING = "Non Acceptable";

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
}