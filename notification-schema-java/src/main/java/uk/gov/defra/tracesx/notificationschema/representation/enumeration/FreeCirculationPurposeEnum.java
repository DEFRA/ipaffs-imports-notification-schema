package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import uk.gov.defra.tracesx.notificationschema.validation.CED;
import uk.gov.defra.tracesx.notificationschema.validation.CHEDPP;
import uk.gov.defra.tracesx.notificationschema.validation.CVEDP;
import uk.gov.defra.tracesx.notificationschema.validation.EntityProperty;

public enum FreeCirculationPurposeEnum implements EntityProperty {
  @CED
  @CVEDP
  ANIMAL_FEEDING_STUFF("Animal Feeding Stuff"),
  @CED
  @CVEDP
  @CHEDPP
  HUMAN_CONSUMPTION("Human Consumption"),
  @CVEDP
  @CHEDPP
  PHARMACEUTICAL_USE("Pharmaceutical Use"),
  @CVEDP
  @CHEDPP
  TECHNICAL_USE("Technical Use"),
  @CED
  FURTHER_PROCESS("Further Process"),
  @CED
  @CVEDP
  @CHEDPP
  OTHER("Other");

  private String value;

  FreeCirculationPurposeEnum(String value) {
    this.value = value;
  }

  @JsonCreator
  public static FreeCirculationPurposeEnum fromValue(String text) {
    for (FreeCirculationPurposeEnum b : FreeCirculationPurposeEnum.values()) {
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
