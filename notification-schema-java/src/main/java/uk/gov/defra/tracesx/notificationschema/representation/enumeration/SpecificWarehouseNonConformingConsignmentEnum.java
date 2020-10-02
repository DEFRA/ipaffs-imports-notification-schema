package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import uk.gov.defra.tracesx.notificationschema.validation.CHEDPP;
import uk.gov.defra.tracesx.notificationschema.validation.CVEDP;
import uk.gov.defra.tracesx.notificationschema.validation.EntityProperty;

public enum SpecificWarehouseNonConformingConsignmentEnum implements EntityProperty {
  @CVEDP
  @CHEDPP
  CUSTOMWAREHOUSE("CustomWarehouse"),
  @CVEDP
  @CHEDPP
  FREEZONEORFREEWAREHOUSE("FreeZoneOrFreeWarehouse"),
  @CVEDP
  @CHEDPP
  SHIPSUPPLIER("ShipSupplier"),
  @CVEDP
  @CHEDPP
  SHIP("Ship");

  private String value;

  SpecificWarehouseNonConformingConsignmentEnum(String value) {
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
