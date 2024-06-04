package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;

public class SpecificWarehouseValidator implements
    ConstraintValidator<SpecificWarehouse, Decision> {

  public boolean isValid(Decision decision, ConstraintValidatorContext context) {

    return decision == null || !(ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE.equals(decision.getDecision())
        && decision.getSpecificWarehouseNonConformingConsignment() == null);
  }
}
