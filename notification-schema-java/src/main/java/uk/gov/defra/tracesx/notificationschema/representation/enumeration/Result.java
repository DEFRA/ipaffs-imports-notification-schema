package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Result {
  SATISFACTORY("Satisfactory"),
  SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION("Satisfactory following official intervention"),
  NOT_SATISFACTORY("Not Satisfactory"),
  NOT_DONE("Not Done"),
  DEROGATION("Derogation"),
  NOT_SET("Not Set");

  private String value;

  Result(String value) {
    this.value = value;
  }

  public static Result fromValue(String text) {
    for (Result u : Result.values()) {
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
