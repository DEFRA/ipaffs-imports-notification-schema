package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhysicalCheckNotDoneReason.OTHER;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhysicalCheckNotDoneReason.REDUCED_CHECKS_REGIME;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_DONE;

public class PhysicalCheckReasonNotDoneValidator
    implements ConstraintValidator<PhysicalCheckReasonNotDone, ConsignmentCheck> {

  @Override
  public void initialize(PhysicalCheckReasonNotDone constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(ConsignmentCheck consignmentCheck, ConstraintValidatorContext context) {
    if (consignmentCheck == null) {
      return true;
    }
    if (consignmentCheck.getPhysicalCheckResult() == NOT_DONE) {
      return REDUCED_CHECKS_REGIME.equals(consignmentCheck.getPhysicalCheckNotDoneReason())
          || OTHER.equals(consignmentCheck.getPhysicalCheckNotDoneReason());
    }
    return true;
  }
}
