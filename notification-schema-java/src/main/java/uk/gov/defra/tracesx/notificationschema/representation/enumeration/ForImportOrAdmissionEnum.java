package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ForImportOrAdmissionEnum {
  DEFINITIVE_IMPORT("Definitive import"),
  HORSES_RE_ENTRY("Horses Re-entry"),
  TEMPORARY_ADMISSION_HORSES("Temporary admission horses");

  private String value;

  ForImportOrAdmissionEnum(String value) {
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
