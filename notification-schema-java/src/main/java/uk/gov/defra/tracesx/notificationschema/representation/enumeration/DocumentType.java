package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentType {
  AIR_WAYBILL("airWaybill"),
  BILL_OF_LADING("billOfLading"),
  CARGO_MANIFEST("cargoManifest"),
  CATCH_CERTIFICATE("catchCertificate"),
  COMMERCIAL_INVOICE("commercialInvoice"),
  CONTAINER_MANIFEST("containerManifest"),
  CUSTOMS_DECLARATION("customsDeclaration"),
  HEALTH_CERTIFICATE("healthCertificate"),
  HEAT_TREATMENT_CERTIFICATE("heatTreatmentCertificate"),
  IMPORT_PERMIT("importPermit"),
  INSPECTION_CERTIFICATE("inspectionCertificate"),
  LABORATORY_SAMPLING_RESULTS_FOR_AFLATOXIN("laboratorySamplingResultsForAflatoxin"),
  LETTER_OF_AUTHORITY("letterOfAuthority"),
  ORIGIN_CERTIFICATE("originCertificate"),
  OTHER("other"),
  PHYTOSANITARY_CERTIFICATE("phytosanitaryCertificate"),
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
