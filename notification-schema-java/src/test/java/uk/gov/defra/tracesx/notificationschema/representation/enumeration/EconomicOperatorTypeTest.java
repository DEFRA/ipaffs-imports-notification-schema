package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class EconomicOperatorTypeTest {
  private final static String CHARITY_STRING = "charity";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = EconomicOperatorType.CHARITY.toString();

    assertEquals(enumResult, CHARITY_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = EconomicOperatorType.CHARITY.getValue();

    assertEquals(enumResult, CHARITY_STRING);
  }
}