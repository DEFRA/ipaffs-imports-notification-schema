package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {
  DRAFT("DRAFT"),
  SUBMITTED("SUBMITTED"),
  VALIDATED("VALIDATED"),
  REJECTED("REJECTED"),
  IN_PROGRESS("IN_PROGRESS"),
  AMEND("AMEND"),
  MODIFY("MODIFY"),
  REPLACED("REPLACED"),
  CANCELLED("CANCELLED"),
  DELETED("DELETED");

  private String value;

  StatusEnum(String value) {
    this.value = value;
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
