package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum InspectionRequired {
  REQUIRED("Required"),
  INCONCLUSIVE("Inconclusive"),
  NOT_REQUIRED("Not required");

  private String value;

  InspectionRequired(String value) {
    this.value = value;
  }

  public static InspectionRequired fromValue(String text) {
    for (InspectionRequired u : InspectionRequired.values()) {
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
