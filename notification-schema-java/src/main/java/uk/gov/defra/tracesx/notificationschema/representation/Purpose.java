package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForNonConformingEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.InternalMarketPurpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PurposeGroupEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.RetrospectiveCloningMergeMethod;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateSerializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoTimeSerializer;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.RetrospectiveCloningProperty;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedpEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskEuCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.PurposeForInternalMarket;
import uk.gov.defra.tracesx.notificationschema.validation.groups.landbridge.NotNullEstimatedArrivalDateValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.landbridge.NotNullEstimatedArrivalTimeValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.landbridge.NotNullPointOfExitValidation;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class Purpose {

  private Boolean conformsToEU;

  @NotNull(
      groups = PurposeForInternalMarket.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.purpose"
              + ".internalmarketpurpose.not.null}")
  @RetrospectiveCloningProperty()
  private InternalMarketPurpose internalMarketPurpose;
  private String thirdCountryTranshipment;
  private ForNonConformingEnum forNonConforming;
  private String regNumber;
  private String shipName;
  private String shipPort;
  private String exitBIP;
  @RetrospectiveCloningProperty()
  private String thirdCountry;
  @RetrospectiveCloningProperty(mergeMethod = RetrospectiveCloningMergeMethod.REPLACE)
  private List<String> transitThirdCountries;
  private ForImportOrAdmissionEnum forImportOrAdmission;
  private String exitDate;
  private String finalBIP;

  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationChedppFieldValidation.class,
          NotificationCvedaEuFieldValidation.class,
          NotificationHighRiskEuCedFieldValidation.class,
          NotificationCvedpEuFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.purpose.purposeGroup"
              + ".not.null}")
  @RetrospectiveCloningProperty()
  private PurposeGroupEnum purposeGroup;

  @NotNull(
      groups = NotNullEstimatedArrivalDateValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.purpose"
          + ".estimatedArrivalDateAtPortOfExit.not.null}")
  @JsonSerialize(using = IsoDateSerializer.class)
  @JsonDeserialize(using = IsoDateDeserializer.class)
  private LocalDate estimatedArrivalDateAtPortOfExit;

  @NotNull(
      groups = NotNullEstimatedArrivalTimeValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.purpose"
          + ".estimatedArrivalTimeAtPortOfExit.not.null}")
  @JsonSerialize(using = IsoTimeSerializer.class)
  @JsonDeserialize(using = IsoTimeDeserializer.class)
  private LocalTime estimatedArrivalTimeAtPortOfExit;

  @NotNull(
      groups = NotNullPointOfExitValidation.class,
      message = "{uk.gov.defra.tracesx.notificationschema.representation.partone.purpose"
          + ".pointOfExit.not.null}")
  private String pointOfExit;
}
