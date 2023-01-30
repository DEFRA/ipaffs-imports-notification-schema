package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE;

import uk.gov.defra.tracesx.notificationschema.representation.Decision;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SpecificWarehouseValidator implements
    ConstraintValidator<SpecificWarehouse, Decision> {

  public boolean isValid(Decision decision, ConstraintValidatorContext context) {

    return decision == null || !(ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE.equals(decision.getDecision())
        && decision.getSpecificWarehouseNonConformingConsignment() == null);
  }
}
