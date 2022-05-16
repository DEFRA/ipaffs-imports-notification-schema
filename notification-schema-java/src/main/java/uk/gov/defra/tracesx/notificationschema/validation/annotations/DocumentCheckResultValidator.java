package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION;

import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DocumentCheckResultValidator
    implements ConstraintValidator<DocumentCheckResult, Notification> {

  @Override
  public void initialize(DocumentCheckResult constraintAnnotation) {
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

    return consignmentCheck.getDocumentCheckResult() != NOT_SET
        && consignmentCheck.getDocumentCheckResult()
        != SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION;
  }
}
