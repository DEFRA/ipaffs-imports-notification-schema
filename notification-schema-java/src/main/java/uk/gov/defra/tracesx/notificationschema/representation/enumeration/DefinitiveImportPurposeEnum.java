package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import uk.gov.defra.tracesx.notificationschema.validation.CVEDA;
import uk.gov.defra.tracesx.notificationschema.validation.EntityProperty;

public enum DefinitiveImportPurposeEnum implements EntityProperty {
  @CVEDA
  SLAUGHTER("slaughter"),
  @CVEDA
  APPROVEDBODIES("approvedbodies"),
  @CVEDA
  QUARANTINE("quarantine");

  private String value;

  DefinitiveImportPurposeEnum(String value) {
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
