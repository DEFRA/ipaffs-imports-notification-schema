package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ImpPlaceOfOriginNotNullValidator implements
    ConstraintValidator<ImpPlaceOfOriginNotNull, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    if (partOne == null) {
      return false;
    }

    return partOne.getConsignor() != null;
  }
}