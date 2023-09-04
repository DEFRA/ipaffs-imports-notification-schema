package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ExternalSystem;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotificationTypeEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.StatusEnum;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeSerializer;
import uk.gov.defra.tracesx.notificationschema.validation.ErrorCodes;
import uk.gov.defra.tracesx.notificationschema.validation.ValidationMessageCode;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.AccompanyingDocuments;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ChedppEstimatedArrivalAtBcp;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.ValidStatus;
import uk.gov.defra.tracesx.notificationschema.validation.groups.BasicValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaEuFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationPart3FieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationVeterinaryValidation;

@Builder(toBuilder = true)
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ValidStatus(groups = BasicValidation.class)
@AccompanyingDocuments(
    groups = NotificationVeterinaryValidation.class)
@ChedppEstimatedArrivalAtBcp(
    groups = NotificationChedppFieldValidation.class,
    message = "{uk.gov.defra.tracesx.notificationschema.representation.partone"
        + ".estimatedarrivalatbcp.must.be.in.future}")
public class Notification {

  @ApiModelProperty(value = "The INS id number for this notification.")
  private int id;

  @ApiModelProperty(
      value =
          "TRACES certificate reference. It consists of certificateType.countryOfDestination"
              + ".Year.GeneratedNumber ie. CVEDA.GB.2018.7654321")
  private String referenceNumber;

  private String agencyOrganisationId;

  @ApiModelProperty(
      value =
          "List of external references, which relate to downstream services")
  private List<ExternalReference> externalReferences;

  @ApiModelProperty(value = "Notification version.")
  private int version;

  @JsonIgnore
  private String rowVersion;

  @JsonSerialize(using = IsoOffsetDateTimeSerializer.class)
  @JsonDeserialize(using = IsoOffsetDateTimeDeserializer.class)
  @ApiModelProperty(value = "Date when the notification was last updated.")
  private LocalDateTime lastUpdated;

  @Valid
  private UserInformation lastUpdatedBy;

  @ApiModelProperty(value = "Type of the notification that has been submitted")
  private NotificationTypeEnum type;

  @NotNull(groups = BasicValidation.class, message = "may not be null or invalid")
  @ApiModelProperty(
      value =
          "Current status of the notification. When created by an importer, the notification have"
              + " the status 'Submitted'. Once the BIP validates the notification, it gets the "
              + "status 'Validated'.")
  private StatusEnum status;

  private SplitConsignment splitConsignment;

  private RiskAssessment riskAssessment;

  private JourneyRiskCategorisation journeyRiskCategorisation;

  private Boolean childNotification;

  private Boolean isHighRiskEuImport;

  @NotNull(
      groups = {
          NotificationHighRiskFieldValidation.class,
          NotificationCvedaEuFieldValidation.class
      },
      message = ErrorCodes.NOT_NULL)
  private PartOne partOne;

  @ApiModelProperty(value = "Identification of the user checking the consignment")
  private String officialVeterinarian;

  @Valid
  private UserInformation decisionBy;

  @JsonSerialize(using = IsoOffsetDateTimeSerializer.class)
  @JsonDeserialize(using = IsoOffsetDateTimeDeserializer.class)
  @ApiModelProperty(value = "Date when the notification was validated or rejected")
  private LocalDateTime decisionDate;

  @Valid
  private PartTwo partTwo;

  @NotNull(groups = NotificationPart3FieldValidation.class, message = ErrorCodes.NOT_NULL)
  private PartThree partThree;

  private Set<ValidationMessageCode> consignmentValidation;

  @ApiModelProperty(
      value =
          "If this notification was created as a replacement for another; the reference of the "
              + "notification this notification replaces")
  private String replaces;

  @ApiModelProperty(
      value = "If the status is REPLACED; the reference of the notification that replaces this one")
  private String replacedBy;

  private String etag;

  @JsonIgnore
  public boolean isCveda() {
    return NotificationTypeEnum.CVEDA.equals(type);
  }

  @JsonIgnore
  public boolean isCvedp() {
    return NotificationTypeEnum.CVEDP.equals(type);
  }

  @JsonIgnore
  public boolean isCed() {
    return NotificationTypeEnum.CED.equals(type);
  }

  @JsonIgnore
  public boolean isChedpp() {
    return NotificationTypeEnum.CHEDPP.equals(type);
  }

  @JsonIgnore
  public boolean isClonedChedP() {
    return NotificationTypeEnum.CVEDP.equals(type) && Objects.nonNull(externalReferences)
        && externalReferences.stream().anyMatch(externalRef ->
        externalRef.getSystem() == ExternalSystem.ECERT);
  }

  @JsonSerialize(using = IsoOffsetDateTimeSerializer.class)
  @JsonDeserialize(using = IsoOffsetDateTimeDeserializer.class)
  private LocalDateTime riskDecisionLockingTime;

  private Boolean isRiskDecisionLocked;
  private Boolean isBulkUploadInProgress;
  private String requestId;
}
