package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
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

  @JsonCreator
  public static NotificationTypeEnum fromValue(String text) {
    for (NotificationTypeEnum b : NotificationTypeEnum.values()) {
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
