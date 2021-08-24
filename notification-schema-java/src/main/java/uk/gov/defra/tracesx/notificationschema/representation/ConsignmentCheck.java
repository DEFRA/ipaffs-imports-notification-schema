package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentificationCheckType;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentityCheckNotDoneReason;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhysicalCheckNotDoneReason;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.DocumentCheckResult;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.EuStandardValidator;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.HighRiskEUDocumentCheckResult;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.IdentityCheckReasonNotDone;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.IdentityCheckResult;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.IdentityCheckType;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.PhysicalCheckReasonNotDone;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.PhysicalCheckResult;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedOrCvedpFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedpFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationDocumentCheckValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskEUDocumentCheckValidation;

import javax.validation.constraints.NotNull;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@DocumentCheckResult(
    groups = NotificationDocumentCheckValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
            + ".documentarycheck.invalid.nonhighriskeu}")
@HighRiskEUDocumentCheckResult(
    groups = NotificationHighRiskEUDocumentCheckValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
            + ".documentarycheck.invalid.highriskeu}")
@IdentityCheckType(
    groups = {
        NotificationCvedpFieldValidation.class
    },
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
            + ".identitychecktype.not.null}")
@IdentityCheckResult(
    groups = NotificationCedFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
            + ".identitycheckresult.not.null}")
@PhysicalCheckResult(
    groups = NotificationCedFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
            + ".physicalcheckresult.not.null}")
@PhysicalCheckReasonNotDone(
    groups = {
        NotificationCvedpFieldValidation.class
    },
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
            + ".reasonphysicalchecknotdone.not.null}")
@IdentityCheckReasonNotDone(
    groups = {
        NotificationCvedpFieldValidation.class
    },
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
            + ".reasonidentitychecknotdone.not.null}")
@EuStandardValidator(
    groups = NotificationCvedaFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
            + ".eustandard.not.null}")
public class ConsignmentCheck {

  @NotNull(
      groups = NotificationCvedaFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
              + ".eustandard.not.null}")
  private Result euStandard;

  @NotNull(
      groups = NotificationCedOrCvedpFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
              + ".documentarycheck.not.null}")
  private Result documentCheckResult;

  private Result nationalRequirements;
  private Result additionalGuarantees;

  @NotNull(
      groups = NotificationCedFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
              + ".identitycheck.not.null}")
  private Boolean identityCheckDone;

  private IdentificationCheckType identityCheckType;

  @NotNull(
      groups = {
          NotificationCvedaFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
              + ".identitycheckresult.not.null}")
  private Result identityCheckResult;
  private IdentityCheckNotDoneReason identityCheckNotDoneReason;

  @NotNull(
      groups = NotificationCedFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
              + ".physicalcheck.not.null}")
  private Boolean physicalCheckDone;

  @NotNull(
      groups = {
          NotificationCvedaFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
              + ".physicalcheckresult.not.null}")
  private Result physicalCheckResult;

  private PhysicalCheckNotDoneReason physicalCheckNotDoneReason;
  private String physicalCheckOtherText;

  @NotNull(
      groups = NotificationCvedaFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
              + ".welfarecheck.not.null}")
  private Result welfareCheck;

  @NotNull(
      groups = NotificationCvedaFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
              + ".animalnumberchecked.not.null}")
  private Integer numberOfAnimalsChecked;

  private Boolean laboratoryCheckDone;

  private Result laboratoryCheckResult;
}
