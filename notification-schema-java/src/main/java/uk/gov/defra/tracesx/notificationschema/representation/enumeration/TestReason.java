package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TestReason {
  RANDOM("Random"),
  SUSPICIOUS("Suspicious");

  private String value;

  TestReason(String value) {
    this.value = value;
  }

  @JsonCreator
  public TestReason fromValue(String text) {
    for (TestReason u : TestReason.values()) {
      if (u.value.equals(text)) {
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
