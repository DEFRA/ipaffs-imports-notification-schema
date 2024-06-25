package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

public class ImpPlaceOfDestinationNotNullValidator implements
    ConstraintValidator<ImpPlaceOfDestinationNotNull, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    if (partOne == null) {
      return false;
    }

    return partOne.getPlaceOfDestination() != null;
  }
}
