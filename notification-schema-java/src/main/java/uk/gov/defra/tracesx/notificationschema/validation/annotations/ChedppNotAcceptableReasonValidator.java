package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.Decision;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChedppNotAcceptableReasonValidator
    implements ConstraintValidator<ChedppNotAcceptableReason, Decision> {

  @Override
  public void initialize(ChedppNotAcceptableReason constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(Decision decision, ConstraintValidatorContext context) {
    if (decision == null) {
      return true;
    }

    if (Boolean.FALSE.equals(decision.getConsignmentAcceptable())) {
      return decision.getChedppNotAcceptableReasons() != null
          && decision.getChedppNotAcceptableReasons().size() > 0
          && decision.getChedppNotAcceptableReasons().stream()
          .noneMatch(notAcceptableReason -> notAcceptableReason.getReason() == null
              || notAcceptableReason.getCommodityOrPackage() == null);
    }

    return true;
  }
}
