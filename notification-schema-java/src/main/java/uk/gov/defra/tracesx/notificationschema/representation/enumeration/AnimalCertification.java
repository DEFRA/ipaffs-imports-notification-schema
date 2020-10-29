package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AnimalCertification {
  APPROVED("Approved"),
  QUARANTINE("Quarantine"),
  FATTENING("Fattening"),
  REGISTERED("Registered"),
  SLAUGHTER("Slaughter"),
  RELAYING("Relaying"),
  PETS("Pets"),
  OTHER("Other"),
  BREEDING("Breeding"),
  CIRCUS("Circus"),
  FEEDING("Animal feeding stuff"),
  REPRODUCTION("Artificial reproduction"),
  COMMERCIAL_SALE("Commercial sale"),
  GAME_RESTOCKING("Game restocking"),
  HUMAN_CONSUMPTION("Human consumption"),
  TECHNICAL_PHARMACEUTICAL_USE("Technical/Pharmaceutical use"),
  PRODUCTION("Production"),
  RACING_COMPETITION("Racing/competition"),
  REJECTED_OR_RETURNED_CONSIGNMENT("Rejected or Returned consignment"),
  REGISTERED_EQUIDAE("Registered equidae"),
  RESCUE("Rescue/Rehoming"),
  RESEARCH("Research"),
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
