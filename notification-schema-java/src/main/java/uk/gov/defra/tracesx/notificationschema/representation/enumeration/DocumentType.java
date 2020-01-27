package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentType {
  AIR_WAYBILL("airWaybill"),
  BILL_OF_LADING("billOfLading"),
  CATCH_CERTIFICATE("catchCertificate"),
  COMMERCIAL_INVOICE("commercialInvoice"),
  CUSTOMS_DECLARATION("customsDeclaration"),
  HEALTH_CERTIFICATE("healthCertificate"),
  IMPORT_PERMIT("importPermit"),
  LABORATORY_SAMPLING_RESULTS_FOR_AFLATOXIN("laboratorySamplingResultsForAflatoxin"),
  LETTER_OF_AUTHORITY("letterOfAuthority"),
  OTHER("other"),
  RAILWAY_BILL("railwayBill"),
  SEA_WAYBILL("seaWaybill"),
  VETERINARY_HEALTH_CERTIFICATE("veterinaryHealthCertificate");

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
