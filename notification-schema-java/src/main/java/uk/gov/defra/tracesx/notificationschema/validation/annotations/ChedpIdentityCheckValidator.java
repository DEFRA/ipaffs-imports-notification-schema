package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.TRUE;

import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChedpIdentityCheckValidator
    implements ConstraintValidator<ChedpIdentityCheck, PartTwo> {

  @Override
  public void initialize(ChedpIdentityCheck constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(PartTwo partTwo, ConstraintValidatorContext context) {
    if (partTwo == null || partTwo.getConsignmentCheck() == null) {
      return false;
    }

    if (partTwo.getConsignmentCheck().getDocumentCheckResult() == Result.NOT_SATISFACTORY
        && (partTwo.getDecision() == null
        || !TRUE.equals(partTwo.getDecision().getConsignmentAcceptable()))) {
      return true;
    } else {
      return partTwo.getConsignmentCheck().getIdentityCheckType() != null
          && partTwo.getConsignmentCheck().getIdentityCheckResult() != null;
    }
  }
}
