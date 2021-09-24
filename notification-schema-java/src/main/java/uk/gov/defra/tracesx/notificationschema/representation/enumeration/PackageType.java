package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PackageType {
  BAG("Bag"),
  BALE("Bale"),
  BALLOON_PROTECTED("Balloon Protected"),
  BOTTLE_FLASK_GLASS("Bottle, flask and other glass packages"),
  BLOCK("Block"),
  BOX("Box"),
  BULK("Bulk"),
  CAN("Can"),
  CARTON("Carton"),
  CASE("Case"),
  CASK("Cask"),
  COFFER("Coffer"),
  CONTAINER("Container"),
  CONTAINER_NOT_SPECIFIED("Container, not otherwise specified as transport equipment"),
  CRATE("Crate"),
  DRUM("Drum"),
  DUNNAGE("Dunnage"),
  IN_BULK("In Bulk"),
  JAR("Jar"),
  LOGS("Logs"),
  LUG("Lug"),
  NATURAL_WOOD_BOX_WITH_SIFT_PROOF("Natural wood box with sift proof walls"),
  NATURAL_WOOD_ORDINARY_BOX("Natural wood ordinary box"),
  OTHER("Other"),
  PACKAGE("Package"),
  PAIL("Pail"),
  PALLET("Pallet"),
  PALLET_BOX("Pallet Box"),
  PERSONAL_LUGGAGE("Personal luggage"),
  PLASTIC_FILM("Plastic film"),
  POLYSTYRENE_BOX("Polystyrene Box"),
  PUNNET("Punnet"),
  REDNET("Rednet"),
  TANK("Tank"),
  TOTE("Tote"),
  TRAY("Tray"),
  TUBE("Tube"),
  VIAL("Vial"),
  WOOD_BARREL("Wooden barrel"),
  WOOD_BARREL_WITH_REMOVABLE_HEAD("Wooden barrel with removable head"),
  WOOD_BUNDLE("Wood bundle"),
  WOOD_CASE_WITH_PALLET_BASE("Wooden case with pallet base"),
  WOOD_CRATE("Wood crate"),
  WOOD_PACKAGE_DISPLAY("Wood package display");

  private String value;

  PackageType(String value) {
    this.value = value;
  }

  public static PackageType fromValue(String text) {
    for (PackageType u : PackageType.values()) {
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
