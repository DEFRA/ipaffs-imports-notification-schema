package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Capacity {

  OFFICIAL_INSPECTOR("OfficialInspector"),
  VETERINARY_INSPECTOR("VeterinaryInspector");

  private String value;

  Capacity(String value) {
    this.value = value;
  }

  @JsonCreator
  public static Capacity fromValue(String text) {
    for (Capacity u : Capacity.values()) {
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
