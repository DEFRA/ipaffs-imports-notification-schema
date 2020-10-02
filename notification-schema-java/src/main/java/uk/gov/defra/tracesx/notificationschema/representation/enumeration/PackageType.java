package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PackageType {
  BAG("Bag"),
  BALE("Bale"),
  BLOCK("Block"),
  BOX("Box"),
  CAN("Can"),
  CARTON("Carton"),
  CASE("Case"),
  CASK("Cask"),
  COFFER("Coffer"),
  CONTAINER("Container, not otherwise specified as transport equipment"),
  CRATE("Crate"),
  DRUM("Drum"),
  IN_BULK("In Bulk"),
  JAR("Jar"),
  PACKAGE("Package"),
  PAIL("Pail"),
  PALLET("Pallet"),
  POLYSTYRENE_BOX("Polystyrene Box"),
  TANK("Tank"),
  TOTE("Tote"),
  TRAY("Tray"),
  TUBE("Tube"),
  VIAL("Vial");

  private String value;

  PackageType(String value) {
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
