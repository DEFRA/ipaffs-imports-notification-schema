package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum IdentityCheckNotDoneReason {
  REDUCED_CHECKS_REGIME("Reduced checks regime"),
  NOT_REQUIRED("Not required");

  private String value;

  IdentityCheckNotDoneReason(String value) {
    this.value = value;
  }

  public static IdentityCheckNotDoneReason fromValue(String text) {
    for (IdentityCheckNotDoneReason u : IdentityCheckNotDoneReason.values()) {
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
