package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentType {
  AIR_WAYBILL("Air Waybill"),
  VETERINARY_HEALTH_CERTIFICATE("Veterinary health certificate");

  private String value;

  DocumentType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static DocumentType fromValue(String text) {
    for (DocumentType t : DocumentType.values()) {
      if (t.value.equalsIgnoreCase(text)) {
        return t;
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
