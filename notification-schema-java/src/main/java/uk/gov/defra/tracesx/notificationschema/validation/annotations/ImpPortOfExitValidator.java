package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.AnimalCertification;

import java.util.Optional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ImpPortOfExitValidator implements ConstraintValidator<ImpPortOfExit, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    return Optional.ofNullable(partOne)
        .map(PartOne::getCommodities)
        .map(Commodities::getAnimalsCertifiedAs)
        .map(
            certifiedAs ->
                certifiedAs != AnimalCertification.TRANSIT
                    || StringUtils.isNotBlank(partOne.getPortOfExit()))
        .orElse(false);
  }
}
