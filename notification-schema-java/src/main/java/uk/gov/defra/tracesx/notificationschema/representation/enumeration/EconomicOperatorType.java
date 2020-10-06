package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum EconomicOperatorType {
  CONSIGNEE("consignee"),
  DESTINATION("destination"),
  EXPORTER("exporter"),
  IMPORTER("importer"),
  CHARITY("charity"),
  COMMERCIAL_TRANSPORTER("commercial transporter"),
  PRIVATE_TRANSPORTER("private transporter"),
  VETERINARIAN("veterinarian"),
  TEMPORARY_ADDRESS("temporary address"),
  PREMISES_OF_ORIGIN("premises of origin"),
  ORGANISATION_BRANCH_ADDRESS("organisation branch address"),
  PACKER("packer");

  private String value;

  EconomicOperatorType(String value) {
    this.value = value;
  }

  public static EconomicOperatorType fromValue(String text) {
    for (EconomicOperatorType u : EconomicOperatorType.values()) {
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
