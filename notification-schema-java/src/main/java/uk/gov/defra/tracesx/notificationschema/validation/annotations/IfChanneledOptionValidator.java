package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IfChanneledOptionValidator implements
    ConstraintValidator<IfChanneledOption, Decision> {

  @Override
  public boolean isValid(Decision decision, ConstraintValidatorContext constraintValidatorContext) {
    return decision == null || !(DecisionEnum.ACCEPTABLE_IF_CHANNELED.equals(decision.getDecision())
        && decision.getIfChanneledOption() == null);
  }
}