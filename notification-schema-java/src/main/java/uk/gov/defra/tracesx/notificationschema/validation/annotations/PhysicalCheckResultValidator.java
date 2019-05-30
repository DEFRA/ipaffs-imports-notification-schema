package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.lang.Boolean.TRUE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;

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
