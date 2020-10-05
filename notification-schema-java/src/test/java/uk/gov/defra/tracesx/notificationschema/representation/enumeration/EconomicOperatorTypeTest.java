package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class EconomicOperatorTypeTest {
  private final static String CHARITY_STRING = "charity";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    EconomicOperatorType enumResult = EconomicOperatorType.fromValue(CHARITY_STRING);

    assertEquals(enumResult, EconomicOperatorType.CHARITY);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    EconomicOperatorType enumResult = EconomicOperatorType.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
