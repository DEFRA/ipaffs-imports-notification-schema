package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ControlStatus {
  REQUIRED("REQUIRED"),
  COMPLETED("COMPLETED");

  private String value;

  ControlStatus(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return this.value;
  }

  @JsonCreator
  public ControlStatus fromValue(String text) {
    for (ControlStatus controlStatus : ControlStatus.values()) {
      if (controlStatus.value.equals(text)) {
        return controlStatus;
      }
    }
    return null;
  }
}
