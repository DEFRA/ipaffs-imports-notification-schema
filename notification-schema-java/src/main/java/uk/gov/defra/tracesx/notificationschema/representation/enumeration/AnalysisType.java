package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum AnalysisType {
  INITIAL("Initial analysis"),
  COUNTER("Counter analysis"),
  SECOND_EXPERT("Second expert analysis");

  private String value;

  AnalysisType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static AnalysisType fromValue(String text) {
    for (AnalysisType u : AnalysisType.values()) {
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