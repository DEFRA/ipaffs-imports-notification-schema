package uk.gov.defra.tracesx.notificationschema.representation.enumeration;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CommodityTemperatureTest {
  private final static String AMBIENT_STRING = "Ambient";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = CommodityTemperature.AMBIENT.toString();

    assertThat(enumResult).isEqualTo(AMBIENT_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = CommodityTemperature.AMBIENT.getValue();

    assertThat(enumResult).isEqualTo(AMBIENT_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    CommodityTemperature enumResult = CommodityTemperature.fromValue(AMBIENT_STRING);

    assertThat(enumResult).isEqualTo(CommodityTemperature.AMBIENT);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    CommodityTemperature enumResult = CommodityTemperature.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
