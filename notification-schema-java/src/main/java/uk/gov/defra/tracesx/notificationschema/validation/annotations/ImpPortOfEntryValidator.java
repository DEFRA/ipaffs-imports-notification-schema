package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

public class ImpPortOfEntryValidator implements
    ConstraintValidator<ImpPortOfEntry, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    if (partOne == null) {
      return false;
    }

    return partOne.getPortOfEntry() != null && !partOne.getPortOfEntry().isBlank();
  }
}
