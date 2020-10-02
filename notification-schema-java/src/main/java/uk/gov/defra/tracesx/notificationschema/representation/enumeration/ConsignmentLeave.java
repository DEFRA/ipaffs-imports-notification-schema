package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ConsignmentLeave {
  YES("YES"),
  NO("NO"),
  IT_HAS_BEEN_DESTROYED("It has been destroyed");

  private String value;

  ConsignmentLeave(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return this.value;
  }
}