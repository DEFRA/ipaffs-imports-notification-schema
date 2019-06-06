package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TransportMethod {
  AEROPLANE("Aeroplane"),
  ROAD_VEHICLE("Road Vehicle"),
  RAILWAY_WAGON("Railway Wagon"),
  SHIP("Ship"),
  OTHER("Other"),
  ROAD_VEHICLE_AEROPLANE("Road vehicle Aeroplane"),
  SHIP_RAILWAY_WAGON("Ship Railway wagon"),
  SHIP_ROAD_VEHICLE("Ship Road vehicle");

  private String value;

  TransportMethod(String value) {
    this.value = value;
  }

  @JsonCreator
  public static TransportMethod fromValue(String text) {
    for (TransportMethod u : TransportMethod.values()) {
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
