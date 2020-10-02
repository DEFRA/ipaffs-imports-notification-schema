package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class CommodityIntentionTest {
  private final static String HUMAN_STRING = "human";

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
}
