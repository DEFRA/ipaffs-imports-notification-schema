package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;

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

    return commodities.getTotalGrossWeight() == null
        || commodities.getTotalNetWeight() == null
        || (commodities.getTotalGrossWeight().compareTo(commodities.getTotalNetWeight()) >= 0);
  }
}
