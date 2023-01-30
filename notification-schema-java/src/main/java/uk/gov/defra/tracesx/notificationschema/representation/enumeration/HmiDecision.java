package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum HmiDecision {
  REQUIRED("REQUIRED"),
  NOT_REQUIRED("NOTREQUIRED");

  private String value;

  HmiDecision(String value) {
    this.value = value;
  }

  public static HmiDecision fromValue(String text) {
    return Arrays.stream(HmiDecision.values())
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