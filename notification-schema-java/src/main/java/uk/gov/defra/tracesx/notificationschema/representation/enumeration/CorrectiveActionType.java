package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CorrectiveActionType {

  DELAYED_DEPARTURE("DelayedDeparture"),
  TRANSFER_PROCEDURE("TransferProcedure"),
  RETURN_OF_CONSIGNMENT("ReturnOfConsignment"),
  HUMANELY_KILLING("HumanelyKilling"),
  DESTRUCTION_OF_CARCASSES_OR_PRODUCTS("DestructionOfCarcassesOrProducts"),
  USE_OF_PRODUCT("UseOfProduct"),
  TREAT_OF_PRODUCTS("TreatOfProducts"),
  QUARANTINE("Quarantine");

  private String value;

  CorrectiveActionType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CorrectiveActionType fromValue(String text) {
    for (CorrectiveActionType u : CorrectiveActionType.values()) {
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
