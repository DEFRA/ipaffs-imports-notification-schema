package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransportType {
  RAIL("rail"),
  PLANE("plane"),
  SHIP("ship"),
  ROAD("road"),
  OTHER("other"),
  CSHIPROAD("c_ship_road"),
  CSHIPRAIL("c_ship_rail");

  private String value;

  TransportType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static TransportType fromValue(String text) {
    for (TransportType b : TransportType.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonValue
  public String toValue() {
    return this.getValue();
  }
}
