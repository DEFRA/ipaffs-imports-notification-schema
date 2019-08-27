package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum InfringementToWelfareRegulationType {

  TRANSPORTER_AUTHORISATION_INVALID("TransporterAuthorisationInvalid"),
  NON_COMPLIANT_MEANS_OF_TRANSPORT("NonComplianceOfTheMeansOfTransport"),
  EXCEEDED_DENSITY("ExceededDensity"),
  TRAVEL_TIME_EXCEEDED("TravelTimesExceeded"),
  WATERING_AND_FEEDING_NOT_FULFILLED("WateringAndFeedingNotFulfilled"),
  MISHANDLING_OR_NEGLIGENCE_TO_THE_ANIMALS("MishandlingOrNegligenceToTheAnimals"),
  SUPPL_MEASURES_LONG_JOURNEY("SupplMeasuresLongJourney"),
  DRIVER_PROFICIENCY("DriverProficiency"),
  REGISTERED_DATA("RegisteredData"),
  OTHER("Other");

  private String value;

  InfringementToWelfareRegulationType(String value) {
    this.value = value;
  }

  @JsonCreator
  public static InfringementToWelfareRegulationType fromValue(String text) {
    for (InfringementToWelfareRegulationType u : InfringementToWelfareRegulationType.values()) {
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
