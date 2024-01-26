package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.validation.utils.ConsignmentCheckUtil;

public class EuStandardValidatorImpl
    implements ConstraintValidator<EuStandardValidator, ConsignmentCheck> {

  @Override
  public boolean isValid(ConsignmentCheck consignmentCheck, ConstraintValidatorContext context) {
    if (consignmentCheck != null
        && ConsignmentCheckUtil.isExistingCHEDANotification(consignmentCheck)) {
      return consignmentCheck.getEuStandard() != NOT_SET;
    }
    return true;
  }

  @Override
  public void initialize(EuStandardValidator constraintAnnotation) {
    // no action
  }
}
