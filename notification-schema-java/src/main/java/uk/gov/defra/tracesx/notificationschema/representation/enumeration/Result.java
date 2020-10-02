package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Result {
  SATISFACTORY("Satisfactory"),
  NOT_SATISFACTORY("Not Satisfactory"),
  NOT_DONE("Not Done"),
  DEROGATION("Derogation"),
  NOT_SET("Not Set");

  private String value;

  Result(String value) {
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
