package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Optional;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.AnimalCertification;

public class ImpPortOfExitDateNotNullValidator
    implements ConstraintValidator<ImpPortOfExitDateNotNull, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    return Optional.ofNullable(partOne)
        .map(PartOne::getCommodities)
        .map(
            commodities ->
                commodities.getAnimalsCertifiedAs() != AnimalCertification.TRANSIT
                    || partOne.getPortOfExitDate() != null)
        .orElse(false);
  }
}
