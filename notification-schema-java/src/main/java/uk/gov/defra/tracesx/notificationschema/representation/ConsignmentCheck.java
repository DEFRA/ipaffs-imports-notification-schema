package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentificationCheckType;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhysicalCheckNotDoneReason;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.DocumentCheckResult;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.EuStandardValidator;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.IdentityCheckResult;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.IdentityCheckType;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.PhysicalCheckReasonNotDone;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.PhysicalCheckResult;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationChedppFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedpFieldValidation;

import javax.validation.constraints.NotNull;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@DocumentCheckResult(
    groups = {
        NotificationCedFieldValidation.class,
        NotificationCvedpFieldValidation.class,
        NotificationChedppFieldValidation.class
    },
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
            + ".documentarycheck.not.null}")
@IdentityCheckType(
    groups = {
        NotificationCvedpFieldValidation.class,
        NotificationChedppFieldValidation.class
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
        NotificationCvedpFieldValidation.class,
        NotificationChedppFieldValidation.class
    },
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
            + ".reasonphysicalchecknotdone.not.null}")
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
      groups = {
          NotificationCedFieldValidation.class,
          NotificationCvedpFieldValidation.class,
          NotificationChedppFieldValidation.class
      },
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

  @NotNull(
      groups = {
          NotificationCvedpFieldValidation.class,
          NotificationChedppFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
              + ".identitychecktype.not.null}")
  private IdentificationCheckType identityCheckType;

  @NotNull(
      groups = {
          NotificationCvedaFieldValidation.class,
          NotificationCvedpFieldValidation.class,
          NotificationChedppFieldValidation.class
      },
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
              + ".identitycheckresult.not.null}")
  private Result identityCheckResult;

  @NotNull(
      groups = NotificationCedFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck"
              + ".physicalcheck.not.null}")
  private Boolean physicalCheckDone;

  @NotNull(
      groups = {
          NotificationCvedaFieldValidation.class,
          NotificationCvedpFieldValidation.class,
          NotificationChedppFieldValidation.class
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
