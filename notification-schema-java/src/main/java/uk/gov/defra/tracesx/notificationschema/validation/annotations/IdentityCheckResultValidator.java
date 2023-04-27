package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.TRUE;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

public class IdentityCheckResultValidator
    implements ConstraintValidator<IdentityCheckResult, ConsignmentCheck> {

  @Override
  public void initialize(IdentityCheckResult constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(ConsignmentCheck consignmentCheck, ConstraintValidatorContext context) {
    if (consignmentCheck == null) {
      return true;
    }
    if (TRUE.equals(consignmentCheck.getIdentityCheckDone())) {
      return consignmentCheck.getIdentityCheckResult() == Result.SATISFACTORY
          || consignmentCheck.getIdentityCheckResult() == Result.NOT_SATISFACTORY;
    }
    return true;
  }
}
