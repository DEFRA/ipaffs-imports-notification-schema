package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PhysicalCheckNotDoneReason {
  REDUCED_CHECKS_REGIME("Reduced checks regime"),
  OTHER("Other");

  private String value;

  PhysicalCheckNotDoneReason(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PhysicalCheckNotDoneReason fromValue(String text) {
    for (PhysicalCheckNotDoneReason u : PhysicalCheckNotDoneReason.values()) {
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
