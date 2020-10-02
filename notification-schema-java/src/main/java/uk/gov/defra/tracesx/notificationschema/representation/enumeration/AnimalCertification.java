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
  REGISTERED_EQUIDAE("Registered equidae"),
  RESCUE("Rescue/Rehoming"),
  RESEARCH("Research"),
  ZOO("Zoo/Collection");

  private String value;

  AnimalCertification(String value) {
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
