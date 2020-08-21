package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class EconomicOperatorStatusTest {
  private final static String SUSPENDED_STRING = "suspended";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    EconomicOperatorStatus enumResult = EconomicOperatorStatus.fromValue(SUSPENDED_STRING);

    assertEquals(enumResult, EconomicOperatorStatus.SUSPENDED);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    EconomicOperatorStatus enumResult = EconomicOperatorStatus.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
