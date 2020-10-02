package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NotificationTypeEnum {
  CVEDA("CVEDA"),
  CVEDP("CVEDP"),
  CHEDPP("CHEDPP"),
  CED("CED"),
  IMP("IMP");

  private String value;

  NotificationTypeEnum(String value) {
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
