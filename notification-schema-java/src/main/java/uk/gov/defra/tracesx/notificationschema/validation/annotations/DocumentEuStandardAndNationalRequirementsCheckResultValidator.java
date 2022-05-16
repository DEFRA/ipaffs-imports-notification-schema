package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;

import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DocumentEuStandardAndNationalRequirementsCheckResultValidator
    implements
    ConstraintValidator<DocumentEuStandardAndNationalRequirementsCheckResult, Notification> {

  @Override
  public void initialize(
      DocumentEuStandardAndNationalRequirementsCheckResult constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(Notification notification, ConstraintValidatorContext context) {

    if (notification == null
        || notification.getPartTwo() == null
        || notification.getPartTwo().getConsignmentCheck() == null

    ) {
      return true;
    }

    ConsignmentCheck consignmentCheck = notification.getPartTwo().getConsignmentCheck();
    Result documentCheck = consignmentCheck.getDocumentCheckResult();
    Result euStandardCheck = consignmentCheck.getEuStandard();
    Result nationalRequirement = consignmentCheck.getNationalRequirements();

    return ((documentCheck == NOT_SET
        && ((euStandardCheck == SATISFACTORY || euStandardCheck == NOT_SATISFACTORY)
        && (nationalRequirement == SATISFACTORY || nationalRequirement == NOT_SATISFACTORY)))
        || (euStandardCheck == NOT_SET && nationalRequirement == NOT_SET
        && (documentCheck == SATISFACTORY || documentCheck == NOT_SATISFACTORY)));
  }
}
