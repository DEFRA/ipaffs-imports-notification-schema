package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PurposeGroupEnum.TRANSIT_TO_3RD_COUNTRY;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;

public class ChedaPartOneDestinationCountryValidator implements
    ConstraintValidator<ChedaPartOneDestinationCountryProvided, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {

    if (partOne == null || partOne.getPurpose() == null) {
      return true;
    }

    Purpose purpose = partOne.getPurpose();

    if (TRANSIT_TO_3RD_COUNTRY.equals(purpose.getPurposeGroup())) {
      return purpose.getThirdCountry() != null && !purpose.getThirdCountry().trim().isEmpty();
    }

    return true;
  }
}
