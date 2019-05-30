package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IdentificationCheckType {
  SEAL_CHECK("Seal Check"),
  FULL_IDENTITY_CHECK("Full Identity Check");

  private String value;

  IdentificationCheckType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static IdentificationCheckType fromValue(String text) {
    for (IdentificationCheckType u : IdentificationCheckType.values()) {
      if (u.value.equals(text)) {
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
