package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_DONE;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

public class IdentityCheckReasonNotDoneValidator
    implements ConstraintValidator<IdentityCheckReasonNotDone, ConsignmentCheck> {

  @Override
  public void initialize(IdentityCheckReasonNotDone constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(ConsignmentCheck consignmentCheck, ConstraintValidatorContext context) {
    if (consignmentCheck == null) {
      return true;
    }
    if (consignmentCheck.getIdentityCheckResult() == NOT_DONE) {
      return consignmentCheck.getIdentityCheckNotDoneReason() != null;
    }
    return true;
  }
}
