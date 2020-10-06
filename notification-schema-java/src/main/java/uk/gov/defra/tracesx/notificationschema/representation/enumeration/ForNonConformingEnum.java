package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ForNonConformingEnum {
  CUSTOMS_WAREHOUSE("Customs Warehouse"),
  FREE_ZONE_OR_FREE_WAREHOUSE("Free Zone or Free Warehouse"),
  SHIP_SUPPLIER("Ship Supplier"),
  SHIP("Ship");

  private String value;

  ForNonConformingEnum(String value) {
    this.value = value;
  }

  public static ForNonConformingEnum fromValue(String text) {
    for (ForNonConformingEnum u : ForNonConformingEnum.values()) {
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
