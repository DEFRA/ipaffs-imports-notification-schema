package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum EconomicOperatorStatus {
  APPROVED("approved"),
  NON_APPROVED("nonapproved"),
  SUSPENDED("suspended");

  private String value;

  EconomicOperatorStatus(String value) {
    this.value = value;
  }

  @JsonCreator
  public static EconomicOperatorStatus fromValue(String text) {
    for (EconomicOperatorStatus u : EconomicOperatorStatus.values()) {
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
