package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AnimalsUnit {
  PERCENT("percent"),
  NUMBER("number");

  private String value;

  AnimalsUnit(String value) {
    this.value = value;
  }

  public static AnimalsUnit fromValue(String text) {
    for (AnimalsUnit u : AnimalsUnit.values()) {
      if (u.value.equalsIgnoreCase(text)) {
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
