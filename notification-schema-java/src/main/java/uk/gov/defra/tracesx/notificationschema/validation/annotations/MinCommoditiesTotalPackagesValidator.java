package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;

public class MinCommoditiesTotalPackagesValidator implements
    ConstraintValidator<MinCommoditiesTotalPackages, Integer> {
  @Override
  public void initialize(MinCommoditiesTotalPackages constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(Integer value, ConstraintValidatorContext context) {
    if (value == null) {
      return false;
    }

    return value>0;
  }

}
