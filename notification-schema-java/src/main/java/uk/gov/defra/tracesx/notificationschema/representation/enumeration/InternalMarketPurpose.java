package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum InternalMarketPurpose {
  ANIMAL_FEEDING_STUFF("Animal Feeding Stuff"),
  HUMAN_CONSUMPTION("Human Consumption"),
  PHARMACEUTICAL_USE("Pharmaceutical Use"),
  TECHNICAL_USE("Technical Use"),
  OTHER("Other"),
  COMMERCIAL_SALE("Commercial Sale"),
  COMMERCIAL_SALE_OR_CHANGE_OF_OWNERSHIP("Commercial sale or change of ownership"),
  RESCUE("Rescue"),
  BREEDING("Breeding"),
  RESEARCH("Research"),
  RACING("Racing or Competition"),
  APPROVED_PREMISES("Approved Premises or Body"),
  COMPANION_ANIMAL("Companion Animal not for Resale or Rehoming"),
  PRODUCTION("Production"),
  SLAUGHTER("Slaughter"),
  FATTENING("Fattening"),
  GAME_RESTOCKING("Game Restocking"),
  REGISTERED_HORSES("Registered Horses");

  private String value;

  InternalMarketPurpose(String value) {
    this.value = value;
  }

  public static InternalMarketPurpose fromValue(String text) {
    for (InternalMarketPurpose u : InternalMarketPurpose.values()) {
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
