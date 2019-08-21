package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InfringementToAnimalHealthLegislation {

  ABSENCE_OR_INVALID_CERTIFICATE("AbsenceOrInvalidCertificate"),
  MISMATCH_WITH_DOCUMENTS("MisMatchwithDocuments"),
  NON_AUTHORISED_MEMBER_STATE("NonAuthorisedMemberstate"),
  NON_APPROVED_REGION_OR_ZONE("NonApprovedRegionOrZone"),
  PROHIBITED_SPECIES("ProhibitedSpecies"),
  ABSENCE_ADDITIONAL_GUARANTEES("AbsenceAdditionalGuarantees"),
  NON_APPROVED_HOLDING("NonApprovedHolding"),
  DISEASED_OR_SUSPECT_ANIMALS("DiseasedOrSuspectAnimals"),
  NON_SATISFACTORY_TESTS("NonSatisfactoryTests"),
  ABSENCE_OR_NON_LEGAL_IDENTIFICATION("AbsenceOrNonLegalIdentification"),
  ABSENCE_NATIONAL_REQUIREMENTS("AbsenceNationalRequirements"),
  ADDRESS_OF_DESTINATION_INVALID("AddressOfDestinationInvalid"),
  OTHER("Other");

  private String value;

  InfringementToAnimalHealthLegislation(String value) {
    this.value = value;
  }

  @JsonCreator
  public static InfringementToAnimalHealthLegislation fromValue(String text) {
    for (InfringementToAnimalHealthLegislation u :
        InfringementToAnimalHealthLegislation.values()) {
      if (u.value.equals(text)) {
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
