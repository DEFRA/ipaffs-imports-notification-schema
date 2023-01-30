package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NotAcceptableReasonsEnum {
  ABSENCEINVALIDCERTIFICATE("AbsenceInvalidCertificate"),
  IDMISMATCHWITHDOCUMENTS("IdMismatchWithDocuments"),
  CHEMICALCONTAMINATION("ChemicalContamination"),
  MICROBIOLOGICALCONTAMINATION("MicrobiologicalContamination"),
  NONAPPROVEDCOUNTRY("NonApprovedCountry"),
  NONAPPROVEDREGION("NonApprovedRegion"),
  NONAPPROVEDESTABLISHMENT("NonApprovedEstablishment"),
  PROHIBITEDPRODUCT("ProhibitedProduct"),
  IDHEALTHMARKERROR("IdHealthMarkError"),
  PHYSICALHYGIENEFAILURE("PhysicalHygieneFailure"),
  ABSENCEADDITIONALGUARANTEES("AbsenceAdditionalGuarantees"),
  SAFEGUARDCLAUSE("SafeguardClause"),
  DISEASEDORSUSPECTANIMALS("DiseasedOrSuspectAnimals"),
  NONSATISFACTORYTESTS("NonSatisfactoryTests"),
  UNFITFORTRAVEL("UnfitForTravel"),
  ABSENCENATIONALREQUIREMENTS("AbsenceNationalRequirements"),
  NONLEGALIDENTIFICATION("NonLegalIdentification"),
  INFRINGEMENTINTTRANSPREG("InfringementIntTranspReg"),
  OTHER("Other"),
  OTHERRASFF("OtherRasff"),
  INVASIVEALIENSPECIES("InvasiveAlienSpecies");

  private String value;

  NotAcceptableReasonsEnum(String value) {
    this.value = value;
  }

  public static NotAcceptableReasonsEnum fromValue(String text) {
    for (NotAcceptableReasonsEnum b : NotAcceptableReasonsEnum.values()) {
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
