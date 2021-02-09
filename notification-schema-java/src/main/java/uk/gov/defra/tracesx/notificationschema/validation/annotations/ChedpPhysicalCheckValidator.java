package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.TRUE;

import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChedpPhysicalCheckValidator
    implements ConstraintValidator<ChedpPhysicalCheck, PartTwo> {

  @Override
  public void initialize(ChedpPhysicalCheck constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(PartTwo partTwo, ConstraintValidatorContext context) {
    if (partTwo == null) {
      return true;
    }

    if (partTwo.getDecision() == null
        || partTwo.getDecision().getConsignmentAcceptable() == null
        || TRUE.equals(partTwo.getDecision().getConsignmentAcceptable())) {
      return partTwo.getConsignmentCheck() != null
          && partTwo.getConsignmentCheck().getPhysicalCheckResult() != null;
    } else {
      return true;
    }
  }
}
