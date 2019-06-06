package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.FALSE;
import static java.util.Objects.nonNull;

import uk.gov.defra.tracesx.notificationschema.representation.Decision;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotAcceptableActionValidator
    implements ConstraintValidator<NotAcceptableAction, Decision> {

  @Override
  public void initialize(NotAcceptableAction constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(Decision decision, ConstraintValidatorContext context) {
    if (decision == null) {
      return true;
    }
    if (FALSE.equals(decision.getConsignmentAcceptable())) {
      return nonNull(decision.getNotAcceptableAction());
    }
    return true;
  }
}
