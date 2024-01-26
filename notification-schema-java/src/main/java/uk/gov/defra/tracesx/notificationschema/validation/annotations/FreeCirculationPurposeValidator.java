package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;

public class FreeCirculationPurposeValidator implements
    ConstraintValidator<FreeCirculationPurpose, Decision> {

  @Override
  public boolean isValid(Decision decision, ConstraintValidatorContext constraintValidatorContext) {
    return decision == null
        || !(DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET.equals(decision.getDecision())
            && decision.getFreeCirculationPurpose() == null);
  }
}
