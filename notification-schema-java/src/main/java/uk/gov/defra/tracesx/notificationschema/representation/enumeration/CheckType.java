package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum CheckType {
  PHSI_DOCUMENT("PHSI_DOCUMENT"),
  PHSI_IDENTITY("PHSI_IDENTITY"),
  PHSI_PHYSICAL("PHSI_PHYSICAL"),
  HMI("HMI");

  private String value;

  CheckType(String value) {
    this.value = value;
  }

  public static CheckType fromValue(String value) {
    return Arrays.stream(values())
        .filter(v -> v.value.equals(value))
        .findFirst()
        .orElse(null);
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
