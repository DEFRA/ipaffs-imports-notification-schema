package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AnalysisType {
  INITIAL("Initial analysis"),
  COUNTER("Counter analysis"),
  SECOND_EXPERT("Second expert analysis");

  private String value;

  AnalysisType(String value) {
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