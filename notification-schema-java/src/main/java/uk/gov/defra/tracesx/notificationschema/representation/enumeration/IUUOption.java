package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum IUUOption {
  IUUOK("IUUOK"),
  IUUNA("IUUNA");

  private String value;

  IUUOption(String value) {
    this.value = value;
  }

  @JsonCreator
  public static IUUOption fromValue(String text) {
    for (IUUOption u : IUUOption.values()) {
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
