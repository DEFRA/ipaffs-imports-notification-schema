package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class CommodityTemperatureTest {
  private final static String AMBIENT_STRING = "Ambient";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    CommodityTemperature enumResult = CommodityTemperature.fromValue(AMBIENT_STRING);

    assertEquals(enumResult, CommodityTemperature.AMBIENT);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    CommodityTemperature enumResult = CommodityTemperature.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
