package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum RiskDecision {
  REQUIRED("REQUIRED"),
  NOT_REQUIRED("NOTREQUIRED"),
  INCONCLUSIVE("INCONCLUSIVE"),
  REENFORCED_CHECK("REENFORCED_CHECK");

  private String value;

  RiskDecision(String value) {
    this.value = value;
  }

  public static RiskDecision fromValue(String text) {
    return Arrays.stream(RiskDecision.values())
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