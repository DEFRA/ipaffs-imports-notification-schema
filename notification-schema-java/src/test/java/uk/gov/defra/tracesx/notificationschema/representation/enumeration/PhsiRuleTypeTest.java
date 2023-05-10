package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class PhsiRuleTypeTest {

  private final static String COMMODITY = "Commodity";
  private final static String CONSIGNMENT = "Consignment";
  private final static String MIXED_CONSIGNMENT = "MixedConsignment";
  private final static String INVALID_STRING = "invalid-string";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = PhsiRuleType.COMMODITY.toString();

    assertEquals(enumResult, COMMODITY);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = PhsiRuleType.CONSIGNMENT.getValue();

    assertEquals(enumResult, CONSIGNMENT);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    PhsiRuleType enumResult = PhsiRuleType.fromValue(MIXED_CONSIGNMENT);

    assertEquals(enumResult, PhsiRuleType.MIXED_CONSIGNMENT);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    PhsiDecision enumResult = PhsiDecision.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }

}
