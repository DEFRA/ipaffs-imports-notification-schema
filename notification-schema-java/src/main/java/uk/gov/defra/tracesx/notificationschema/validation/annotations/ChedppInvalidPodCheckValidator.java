package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChedppInvalidPodCheckValidator
    implements ConstraintValidator<ChedppInvalidPodCheck, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    if (partOne == null || partOne.getCommodities() == null) {
      return true;
    }

    return !(partOne.getPod() != null
        && partOne.getCommodities().getCountryOfOriginIsPodCountry() != null
        && partOne.getCommodities().getCountryOfOriginIsPodCountry().equals(Boolean.FALSE));
  }
}