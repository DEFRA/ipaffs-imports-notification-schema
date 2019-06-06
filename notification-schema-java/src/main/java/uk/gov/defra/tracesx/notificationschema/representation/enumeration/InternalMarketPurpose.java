package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InternalMarketPurpose {
  ANIMAL_FEEDING_STUFF("Animal Feeding Stuff"),
  HUMAN_CONSUMPTION("Human Consumption"),
  PHARMACEUTICAL_USE("Pharmaceutical Use"),
  TECHNICAL_USE("Technical Use"),
  OTHER("Other");

  private String value;

  InternalMarketPurpose(String value) {
    this.value = value;
  }

  @JsonCreator
  public static InternalMarketPurpose fromValue(String text) {
    for (InternalMarketPurpose u : InternalMarketPurpose.values()) {
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
