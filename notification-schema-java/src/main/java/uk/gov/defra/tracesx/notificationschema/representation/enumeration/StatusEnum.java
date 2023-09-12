package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatusEnum {
  DRAFT("DRAFT"),
  SUBMITTED("SUBMITTED"),
  VALIDATED("VALIDATED"),
  REJECTED("REJECTED"),
  IN_PROGRESS("IN_PROGRESS"),
  AMEND("AMEND"),
  MODIFY("MODIFY"),
  REPLACED("REPLACED"),
  CANCELLED("CANCELLED"),
  DELETED("DELETED"),
  PARTIALLY_REJECTED("PARTIALLY_REJECTED"),
  SPLIT_CONSIGNMENT("SPLIT_CONSIGNMENT"),
  TO_PROCESS(String.join(",", SUBMITTED.value, IN_PROGRESS.value, MODIFY.value));

  private String value;

  StatusEnum(String value) {
    this.value = value;
  }

  public static StatusEnum fromValue(String text) {
    for (StatusEnum b : StatusEnum.values()) {
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
