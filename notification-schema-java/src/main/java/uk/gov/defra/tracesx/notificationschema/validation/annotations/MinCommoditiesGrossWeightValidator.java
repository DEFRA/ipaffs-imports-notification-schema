package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.Commodities;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinCommoditiesGrossWeightValidator
    implements ConstraintValidator<MinCommoditiesGrossWeight, Commodities> {

  @Override
  public void initialize(MinCommoditiesGrossWeight constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(Commodities commodities, ConstraintValidatorContext context) {
    if (commodities == null) {
      return true;
    }

    if (commodities.getTotalGrossWeight() != null
        && commodities.getTotalNetWeight() != null
        && (commodities.getTotalGrossWeight().compareTo(commodities.getTotalNetWeight()) < 0)) {
      return false;
    }
    return true;
  }
}
