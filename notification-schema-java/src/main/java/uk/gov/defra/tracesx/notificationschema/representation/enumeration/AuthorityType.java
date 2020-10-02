package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AuthorityType {
  EXITBIP("exitbip"),
  FINALBIP("finalbip"),
  LOCALVETUNIT("localvetunit"),
  INSPUNIT("inspunit");

  private String value;

  AuthorityType(String value) {
    this.value = value;
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
