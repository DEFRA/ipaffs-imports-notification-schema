package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.InspectionRequired;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeSerializer;
import uk.gov.defra.tracesx.notificationschema.validation.ValidationMessageCode;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.CedOrCvedpControlledDestination;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedpIdentityCheck;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedpPhysicalCheck;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.CvedaControlledDestination;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.LaboratoryTestsNotAdded;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.LaboratoryTestsPending;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedOrCvedpFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedpFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskNonChedppFieldValidation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@LaboratoryTestsNotAdded(
    groups = NotificationHighRiskNonChedppFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo"
            + ".reasonlaboratorytestsnotadded.not.empty}")
@LaboratoryTestsPending(
    groups = NotificationHighRiskNonChedppFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.laboratorytestspending"
            + ".not.empty}")
@CvedaControlledDestination(
    groups = NotificationCvedaFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.controlleddestination"
            + ".not.empty}")
@CedOrCvedpControlledDestination(
    groups = NotificationCedOrCvedpFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.controlleddestination"
            + ".not.empty}")
@ChedpIdentityCheck(groups = NotificationCvedpFieldValidation.class)
@ChedpPhysicalCheck(groups = NotificationCvedpFieldValidation.class)
public class PartTwo {

  @Valid
  private Decision decision;

  @Valid
  private ConsignmentCheck consignmentCheck;

  private ImpactOfTransportOnAnimals impactOfTransportOnAnimals;

  @NotNull(
      groups = NotificationHighRiskNonChedppFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo"
              + ".laboratorytestsrequired.not.null}")
  private Boolean laboratoryTestsRequired;

  @Valid
  private LaboratoryTests laboratoryTests;

  private Boolean resealedContainersIncluded;

  private List<String> resealedContainers;

  private List<NotificationSealsContainers> resealedContainersMapping;

  @Valid
  private ControlAuthority controlAuthority;

  private String bipLocalReferenceNumber;
  private String signedOnBehalfOf;
  private String onwardTransportation;
  private Set<ValidationMessageCode> consignmentValidation;
  private EconomicOperator controlledDestination;

  @JsonSerialize(using = IsoOffsetDateTimeSerializer.class)
  @JsonDeserialize(using = IsoOffsetDateTimeDeserializer.class)
  private LocalDateTime checkDate;

  private List<AccompanyingDocument> accompanyingDocuments;

  private List<CommodityChecks> commodityChecks;

  private Boolean phsiAutoCleared;

  private Boolean hmiAutoCleared;

  private InspectionRequired inspectionRequired;

  private InspectionOverride inspectionOverride;
}
