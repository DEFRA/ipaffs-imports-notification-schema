package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.FALSE;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableReasonsEnum;

public class NotAcceptableOtherReasonValidator
    implements ConstraintValidator<NotAcceptableOtherReason, Decision> {

  @Override
  public void initialize(NotAcceptableOtherReason constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(Decision decision, ConstraintValidatorContext context) {
    if (decision == null) {
      return true;
    }
    if (FALSE.equals(decision.getConsignmentAcceptable())
        && decision.getNotAcceptableReasons() != null
        && !decision.getNotAcceptableReasons().isEmpty()) {

      for (NotAcceptableReasonsEnum notAcceptableReasons : decision.getNotAcceptableReasons()) {
        if (notAcceptableReasons == NotAcceptableReasonsEnum.OTHER) {
          return isNotEmpty(decision.getNotAcceptableOtherReason());
        }
      }
    }
    return true;
  }
}
