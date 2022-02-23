package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EuStandardValidatorImpl
    implements ConstraintValidator<EuStandardValidator, ConsignmentCheck> {

  @Override
  public boolean isValid(ConsignmentCheck consignmentCheck, ConstraintValidatorContext context) {
    return consignmentCheck.getEuStandard() != Result.NOT_SET;
  }

  @Override
  public void initialize(EuStandardValidator constraintAnnotation) {
    // no action
  }
}