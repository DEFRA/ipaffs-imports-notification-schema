package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PartyType {
  COMMERCIAL_TRANSPORTER("Commercial transporter"),
  PRIVATE_TRANSPORTER("Private transporter");

  private String value;

  PartyType(String value) {
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
