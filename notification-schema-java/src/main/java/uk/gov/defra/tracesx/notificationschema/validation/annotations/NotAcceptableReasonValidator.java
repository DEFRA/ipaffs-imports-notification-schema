package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.Decision;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotAcceptableReasonValidator
    implements ConstraintValidator<NotAcceptableReason, Decision> {

  @Override
  public void initialize(NotAcceptableReason constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(Decision decision, ConstraintValidatorContext context) {
    if (decision == null) {
      return true;
    }
    if (Boolean.FALSE.equals(decision.getConsignmentAcceptable())) {
      return decision.getNotAcceptableReasons() != null
          && !decision.getNotAcceptableReasons().isEmpty();
    }
    return true;
  }
}
