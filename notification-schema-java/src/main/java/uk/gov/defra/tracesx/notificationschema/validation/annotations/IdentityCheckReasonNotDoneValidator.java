package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhysicalCheckNotDoneReason.OTHER;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhysicalCheckNotDoneReason.REDUCED_CHECKS_REGIME;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_DONE;

import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

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
          || OTHER.equals(consignmentCheck.getIdentityCheckNotDoneReason());
    }
    return true;
  }
}
