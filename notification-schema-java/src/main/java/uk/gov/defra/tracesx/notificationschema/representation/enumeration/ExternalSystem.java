package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ExternalSystem {
  TRACESNT("TRACESNT");

  private String value;

  ExternalSystem(String value) {
    this.value = value;
  }

  public static ExternalSystem fromValue(String text) {
    for (ExternalSystem b : ExternalSystem.values()) {
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
