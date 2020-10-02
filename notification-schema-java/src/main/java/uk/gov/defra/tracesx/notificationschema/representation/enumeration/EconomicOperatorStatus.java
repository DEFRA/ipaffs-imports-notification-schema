package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EconomicOperatorStatus {
  APPROVED("approved"),
  NON_APPROVED("nonapproved"),
  SUSPENDED("suspended");

  private String value;

  EconomicOperatorStatus(String value) {
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
