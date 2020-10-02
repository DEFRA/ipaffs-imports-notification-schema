package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class EconomicOperatorStatusTest {
  private final static String SUSPENDED_STRING = "suspended";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = EconomicOperatorStatus.SUSPENDED.toString();

    assertEquals(enumResult, SUSPENDED_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = EconomicOperatorStatus.SUSPENDED.getValue();

    assertEquals(enumResult, SUSPENDED_STRING);
  }
}