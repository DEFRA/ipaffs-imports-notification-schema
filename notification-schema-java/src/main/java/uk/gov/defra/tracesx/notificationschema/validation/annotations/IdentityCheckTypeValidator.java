package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentificationCheckType;

public class IdentityCheckTypeValidator
    implements ConstraintValidator<IdentityCheckType, ConsignmentCheck> {

  @Override
  public void initialize(IdentityCheckType constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(ConsignmentCheck consignmentCheck, ConstraintValidatorContext context) {
    if (consignmentCheck == null) {
      return true;
    }
    if (consignmentCheck.getIdentityCheckResult() == SATISFACTORY) {
      return consignmentCheck.getIdentityCheckType() == IdentificationCheckType.FULL_IDENTITY_CHECK
          || consignmentCheck.getIdentityCheckType() == IdentificationCheckType.SEAL_CHECK;
    }
    return true;
  }
}
