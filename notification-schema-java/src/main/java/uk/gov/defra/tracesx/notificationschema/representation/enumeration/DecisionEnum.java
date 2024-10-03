package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import uk.gov.defra.tracesx.notificationschema.validation.CED;
import uk.gov.defra.tracesx.notificationschema.validation.CHEDPP;
import uk.gov.defra.tracesx.notificationschema.validation.CVEDA;
import uk.gov.defra.tracesx.notificationschema.validation.CVEDP;
import uk.gov.defra.tracesx.notificationschema.validation.EntityProperty;

public enum DecisionEnum implements EntityProperty {
  @CED
  @CVEDP
  @CHEDPP
  @CVEDA
  NON_ACCEPTABLE("Non Acceptable"),
  @CED
  @CVEDP
  @CHEDPP
  @CVEDA
  ACCEPTABLE_FOR_INTERNAL_MARKET("Acceptable for Internal Market"),
  @CED
  ACCEPTABLE_FOR_NON_INTERNAL_MARKET("Acceptable for Non Internal Market"),
  @CVEDP
  @CHEDPP
  ACCEPTABLE_IF_CHANNELED("Acceptable if Channeled"),
  @CED
  @CVEDP
  @CHEDPP
  @CVEDA
  ACCEPTABLE_FOR_TRANSHIPMENT("Acceptable for Transhipment"),
  @CVEDP
  @CVEDA
  ACCEPTABLE_FOR_TRANSIT("Acceptable for Transit"),
  @CVEDA
  ACCEPTABLE_FOR_TEMPORARY_IMPORT("Acceptable for Temporary Import"),
  @CVEDP
  @CHEDPP
  ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE("Acceptable for Specific Warehouse"),
  @CVEDA
  HORSE_REENTRY("Horse Re-entry"),
  @CHEDPP
  ACCEPTABLE_FOR_PRIVATE_IMPORT("Acceptable for Private Import"),
  @CHEDPP
  ACCEPTABLE_FOR_TRANSFER("Acceptable for Transfer");

  private String value;

  DecisionEnum(String value) {
    this.value = value;
  }

  public static DecisionEnum fromValue(String text) {
    for (DecisionEnum b : DecisionEnum.values()) {
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
