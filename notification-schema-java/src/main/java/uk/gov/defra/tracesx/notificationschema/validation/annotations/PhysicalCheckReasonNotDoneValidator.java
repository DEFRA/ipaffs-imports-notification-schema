package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhysicalCheckNotDoneReason.OTHER;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhysicalCheckNotDoneReason.REDUCED_CHECKS_REGIME;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_DONE;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

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
