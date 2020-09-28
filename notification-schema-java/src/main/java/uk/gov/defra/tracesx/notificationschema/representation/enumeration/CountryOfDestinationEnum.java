package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CountryOfDestinationEnum {
  GB("GB"),
  NI("XI");

  private String value;

  CountryOfDestinationEnum(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CountryOfDestinationEnum fromValue(String text) {
    for (CountryOfDestinationEnum b : CountryOfDestinationEnum.values()) {
      if (b.value.equals(text)) {
        return b;
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
