package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class CommodityTemperatureTest {
  private final static String AMBIENT_STRING = "Ambient";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = CommodityTemperature.AMBIENT.toString();

    assertEquals(enumResult, AMBIENT_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = CommodityTemperature.AMBIENT.getValue();

    assertEquals(enumResult, AMBIENT_STRING);
  }
}