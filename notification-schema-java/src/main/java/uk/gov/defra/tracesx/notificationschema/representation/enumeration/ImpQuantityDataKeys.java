package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ImpQuantityDataKeys {
  QUANTITY("quantity"),
  ANIMALS("imp_number_animal"),
  UNITS("number_of_units"),
  KILOGRAMS("kilograms"),
  WEIGHT("imp_weight");

  private String value;

  ImpQuantityDataKeys(String value) {
    this.value = value;
  }

  public static ImpQuantityDataKeys fromValue(String text) {
    for (ImpQuantityDataKeys u : ImpQuantityDataKeys.values()) {
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
