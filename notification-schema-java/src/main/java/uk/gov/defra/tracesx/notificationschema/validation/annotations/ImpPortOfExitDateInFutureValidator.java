package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.Optional;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.AnimalCertification;

public class ImpPortOfExitDateInFutureValidator
    implements ConstraintValidator<ImpPortOfExitDateInFuture, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    return Optional.ofNullable(partOne)
        .map(PartOne::getCommodities)
        .map(Commodities::getAnimalsCertifiedAs)
        .filter(AnimalCertification.TRANSIT::equals)
        .map(certifiedAs -> isValidExitDate(Optional.ofNullable(partOne.getPortOfExitDate())))
        .orElse(true);
  }

  private boolean isValidExitDate(Optional<LocalDate> exitDate) {
    return exitDate.map(date -> !date.isBefore(LocalDate.now())).orElse(true);
  }
}
