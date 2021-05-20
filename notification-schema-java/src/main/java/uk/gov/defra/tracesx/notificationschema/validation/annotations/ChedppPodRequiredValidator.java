package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChedppPodRequiredValidator implements ConstraintValidator<ChedppPodRequired, PartOne> {

  private static final String VIA_TEMPORARY_PLACE_OF_DESTINATION = "POD";

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    if (partOne == null || partOne.getPointOfEntryControlPoint() == null) {
      return true;
    }

    return !(partOne.getPointOfEntryControlPoint().equals(VIA_TEMPORARY_PLACE_OF_DESTINATION)
        && partOne.getPod() == null);
  }
}