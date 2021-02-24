package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.AnimalCertification;

import java.util.Optional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ImpPortOfExitDateNotNullValidator
    implements ConstraintValidator<ImpPortOfExitDateNotNull, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    return Optional.ofNullable(partOne)
        .map(PartOne::getCommodities)
        .map(Commodities::getAnimalsCertifiedAs)
        .map(
            certifiedAs ->
                certifiedAs != AnimalCertification.TRANSIT || partOne.getPortOfExitDate() != null)
        .orElse(false);
  }
}
