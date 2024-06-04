package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

public class PortOfEntryAndPointOfEntryNotEmptyValidator implements
    ConstraintValidator<PortOfEntryAndPointOfEntryNotEmpty, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    if (partOne == null) {
      return false;
    }

    return partOne.getPortOfEntry() != null && !partOne.getPortOfEntry().isBlank()
        && partOne.getPointOfEntry() != null && !partOne.getPointOfEntry().isBlank();
  }
}
