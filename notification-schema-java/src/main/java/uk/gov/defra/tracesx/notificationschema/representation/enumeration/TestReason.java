package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum TestReason {
  RANDOM("Random"),
  SUSPICIOUS("Suspicious"),
  REENFORCED("Re-enforced"),
  INTENSIFIED_CONTROLS("Intensified controls"),
  REQUIRED("Required"),
  LATENT_INFECTION_SAMPLING("Latent infection sampling");

  private String value;

  TestReason(String value) {
    this.value = value;
  }

  @JsonCreator
  public TestReason fromValue(String text) {
    for (TestReason u : TestReason.values()) {
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
