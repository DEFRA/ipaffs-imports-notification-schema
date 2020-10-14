package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum CheckStatus {
  TO_DO("To do"),
  COMPLIANT("Compliant"),
  NON_COMPLIANT("Non compliant"),
  NOT_INSPECTED("Not inspected"),
  HOLD("Hold");

  private String value;

  CheckStatus(String value) {
    this.value = value;
  }

  public static CheckStatus fromValue(String value) {
    return Arrays.stream(values())
        .filter(v -> v.value.equals(value))
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
