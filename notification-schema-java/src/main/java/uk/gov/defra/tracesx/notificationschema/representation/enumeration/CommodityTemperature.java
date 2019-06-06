package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CommodityTemperature {
  AMBIENT("Ambient"),
  CHILLED("Chilled"),
  FROZEN("Frozen");

  private String value;

  CommodityTemperature(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CommodityTemperature fromValue(String text) {
    for (CommodityTemperature u : CommodityTemperature.values()) {
      if (u.value.equals(text)) {
        return u;
      }
    }
    return null;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return value;
  }
}
