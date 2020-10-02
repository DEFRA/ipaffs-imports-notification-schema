package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Conclusion {
  SATISFACTORY("Satisfactory"),
  NOT_SATISFACTORY("Not satisfactory"),
  NOT_INTERPRETABLE("Not interpretable"),
  PENDING("Pending");

  private String value;

  Conclusion(String value) {
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
