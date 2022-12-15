package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentType {
  AIR_WAYBILL("airWaybill"),
  BILL_OF_LADING("billOfLading"),
  CARGO_MANIFEST("cargoManifest"),
  CATCH_CERTIFICATE("catchCertificate"),
  COMMERCIAL_DOCUMENT("commercialDocument"),
  COMMERCIAL_INVOICE("commercialInvoice"),
  CONFORMITY_CERTIFICATE("conformityCertificate"),
  CONTAINER_MANIFEST("containerManifest"),
  CUSTOMS_DECLARATION("customsDeclaration"),
  DOCOM("docom"),
  HEALTH_CERTIFICATE("healthCertificate"),
  HEAT_TREATMENT_CERTIFICATE("heatTreatmentCertificate"),
  IMPORT_PERMIT("importPermit"),
  INSPECTION_CERTIFICATE("inspectionCertificate"),
  ITAHC("itahc"),
  JOURNEY_LOG("journeyLog"),
  LABORATORY_SAMPLING_RESULTS_FOR_AFLATOXIN("laboratorySamplingResultsForAflatoxin"),
  LATEST_VETERINARY_HEALTH_CERTIFICATE("latestVeterinaryHealthCertificate"),
  LETTER_OF_AUTHORITY("letterOfAuthority"),
  LICENCE_OR_AUTHORISATION("licenseOrAuthorisation"),
  MYCOTOXIN_CERTIFICATION("mycotoxinCertification"),
  ORIGIN_CERTIFICATE("originCertificate"),
  OTHER("other"),
  PHYTOSANITARY_CERTIFICATE("phytosanitaryCertificate"),
  PROCESSING_STATEMENT("processingStatement"),
  PROOF_OF_STORAGE("proofOfStorage"),
  RAILWAY_BILL("railwayBill"),
  SEA_WAYBILL("seaWaybill"),
  VETERINARY_HEALTH_CERTIFICATE("veterinaryHealthCertificate");

  private String value;

  DocumentType(String value) {
    this.value = value;
  }

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
