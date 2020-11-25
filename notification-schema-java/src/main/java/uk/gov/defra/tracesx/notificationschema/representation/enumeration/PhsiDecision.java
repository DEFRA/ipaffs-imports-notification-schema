package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum PhsiDecision {
  REQUIRED("REQUIRED"),
  NOT_REQUIRED("NOTREQUIRED");

  private String value;

  PhsiDecision(String value) {
    this.value = value;
  }

  public static PhsiDecision fromValue(String text) {
    return Arrays.stream(PhsiDecision.values())
        .filter(label -> label.value.equals(text))
        .findFirst()
        .orElse(null);
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