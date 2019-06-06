package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
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
  CIRCUS("Circus");

  private String value;

  AnimalCertification(String value) {
    this.value = value;
  }

  @JsonCreator
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
