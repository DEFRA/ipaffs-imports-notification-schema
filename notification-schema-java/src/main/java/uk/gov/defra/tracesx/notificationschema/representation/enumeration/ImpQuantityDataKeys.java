package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ImpQuantityDataKeys {
  QUANTITY("quantity"),
  ANIMALS("imp_number_animal"),
  UNITS("number_of_units"),
  KILOGRAMS("kilograms");

  private String value;

  ImpQuantityDataKeys(String value) {
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
