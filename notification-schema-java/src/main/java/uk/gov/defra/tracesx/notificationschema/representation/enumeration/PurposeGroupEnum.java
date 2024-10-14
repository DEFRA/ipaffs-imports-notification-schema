package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PurposeGroupEnum {
  IMPORT("For Import"),
  NON_CONFORMING_CONSIGNMENTS("For NON-Conforming Consignments"),
  TRANSHIPMENT_TO("For Transhipment to"),
  TRANSIT_TO_3RD_COUNTRY("For Transit to 3rd Country"),
  RE_IMPORT("For Re-Import"),
  PRIVATE_IMPORT("For Private Import"),
  TRANSFER_TO("For Transfer To"),
  RE_CONFORMITY_CHECK("For Import Re-Conformity Check"),
  NON_INTERNAL_MARKET("For Import Non-Internal Market");

  private String value;

  PurposeGroupEnum(String value) {
    this.value = value;
  }

  public static PurposeGroupEnum fromValue(String text) {
    for (PurposeGroupEnum u : PurposeGroupEnum.values()) {
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
