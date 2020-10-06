package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import uk.gov.defra.tracesx.notificationschema.validation.CHEDPP;
import uk.gov.defra.tracesx.notificationschema.validation.CVEDP;
import uk.gov.defra.tracesx.notificationschema.validation.EntityProperty;

public enum IfChanneledOptionEnum implements EntityProperty {
  @CVEDP
  @CHEDPP
  ARTICLE8("article8"),
  @CVEDP
  @CHEDPP
  ARTICLE15("article15");

  private String value;

  IfChanneledOptionEnum(String value) {
    this.value = value;
  }

  public static IfChanneledOptionEnum fromValue(String text) {
    for (IfChanneledOptionEnum u : IfChanneledOptionEnum.values()) {
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
