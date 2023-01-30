package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class CommodityIntentionTest {
  private final static String HUMAN_STRING = "human";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = CommodityIntention.HUMAN.toString();

    assertEquals(enumResult, HUMAN_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = CommodityIntention.HUMAN.getValue();

    assertEquals(enumResult, HUMAN_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    CommodityIntention enumResult = CommodityIntention.fromValue(HUMAN_STRING);

    assertEquals(enumResult, CommodityIntention.HUMAN);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    CommodityIntention enumResult = CommodityIntention.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
