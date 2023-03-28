package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

public enum PhsiRuleType {
  COMMODITY("Commodity"),
  CONSIGNMENT("Consignment"),
  MIXED_CONSIGNMENT("MixedConsignment");

  private final String value;

  PhsiRuleType(String value) {
    this.value = value;
  }

  public static PhsiRuleType fromValue(String text) {
    return Arrays.stream(PhsiRuleType.values())
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
