package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AnimalCertification {
  APPROVED("Approved"),
  BREEDING("Breeding"),
  CIRCUS("Circus"),
  COMMERCIAL_SALE("Commercial sale"),
  FATTENING("Fattening"),
  FEEDING("Animal feeding stuff"),
  GAME_RESTOCKING("Game restocking"),
  HUMAN_CONSUMPTION("Human consumption"),
  INTERNAL_MARKET("Internal market"),
  OTHER("Other"),
  PERSONALLY_OWNED_PETS_NOT_FOR_REHOMING("Personally owned pets not for rehoming"),
  PETS("Pets"),
  PRODUCTION("Production"),
  QUARANTINE("Quarantine"),
  RACING_COMPETITION("Racing/Competition"),
  REGISTERED("Registered"),
  REGISTERED_EQUIDAE("Registered equidae"),
  REJECTED_OR_RETURNED_CONSIGNMENT("Rejected or Returned consignment"),
  RELAYING("Relaying"),
  REPRODUCTION("Artificial reproduction"),
  RESCUE("Rescue/Rehoming"),
  RESEARCH("Research"),
  SLAUGHTER("Slaughter"),
  TECHNICAL_PHARMACEUTICAL_USE("Technical/Pharmaceutical use"),
  TRANSHIPMENT("Transhipment"),
  TRANSIT("Transit"),
  ZOO("Zoo/Collection");

  private String value;

  AnimalCertification(String value) {
    this.value = value;
  }

  public static AnimalCertification fromValue(String text) {
    for (AnimalCertification b : AnimalCertification.values()) {
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
