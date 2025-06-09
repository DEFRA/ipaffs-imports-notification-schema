package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

public enum PhsiClassification {
  MANDATORY("Mandatory"),
  REDUCED("Reduced"),
  CONTROLLED("Controlled"),
  NOT_NOTIFIABLE("NotNotifiable");

  private String value;

  PhsiClassification(String value) {
    this.value = value;
  }

  public static PhsiClassification fromValue(String text) {
    return Arrays.stream(PhsiClassification.values())
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
