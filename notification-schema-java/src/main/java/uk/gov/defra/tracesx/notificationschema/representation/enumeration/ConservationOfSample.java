package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ConservationOfSample {
  AMBIENT("Ambient"),
  CHILLED("Chilled"),
  FROZEN("Frozen");

  private String value;

  ConservationOfSample(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ConservationOfSample fromValue(String text) {
    for (ConservationOfSample u : ConservationOfSample.values()) {
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
