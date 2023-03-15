package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentityCheckNotDoneReason.NOT_REQUIRED;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentityCheckNotDoneReason.REDUCED_CHECKS_REGIME;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_DONE;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
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
      return REDUCED_CHECKS_REGIME.equals(consignmentCheck.getIdentityCheckNotDoneReason())
          || NOT_REQUIRED.equals(consignmentCheck.getIdentityCheckNotDoneReason());
    }
    return true;
  }
}
