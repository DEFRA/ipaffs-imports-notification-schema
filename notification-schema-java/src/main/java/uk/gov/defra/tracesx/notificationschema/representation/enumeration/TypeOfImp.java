package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TypeOfImp {
  LIVE_ANIMALS("A"),
  PRODUCTS_OF_ANIMAL_ORIGIN("P"),
  HIGH_RISK_FOOD_AND_FEED("D");

  private String value;

  TypeOfImp(String value) {
    this.value = value;
  }

  public static TypeOfImp fromValue(String text) {
    for (TypeOfImp b : TypeOfImp.values()) {
      if (String.valueOf(b.value).equals(text)) {
        return b;
      }
    }
    return null;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonValue
  public String toValue() {
    return this.getValue();
  }
}
