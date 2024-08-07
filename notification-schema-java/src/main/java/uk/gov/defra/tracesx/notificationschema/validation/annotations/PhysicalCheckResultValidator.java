package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.TRUE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

public class PhysicalCheckResultValidator
    implements ConstraintValidator<PhysicalCheckResult, ConsignmentCheck> {

  @Override
  public void initialize(PhysicalCheckResult constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(ConsignmentCheck consignmentCheck, ConstraintValidatorContext context) {
    if (consignmentCheck == null) {
      return true;
    }
    if (TRUE.equals(consignmentCheck.getPhysicalCheckDone())) {
      return consignmentCheck.getPhysicalCheckResult() == SATISFACTORY
          || consignmentCheck.getPhysicalCheckResult() == NOT_SATISFACTORY;
    }
    return true;
  }
}
