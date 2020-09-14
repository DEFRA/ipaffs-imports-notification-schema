package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
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

  @JsonCreator
  public static AuthorityType fromValue(String text) {
    for (AuthorityType b : AuthorityType.values()) {
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
