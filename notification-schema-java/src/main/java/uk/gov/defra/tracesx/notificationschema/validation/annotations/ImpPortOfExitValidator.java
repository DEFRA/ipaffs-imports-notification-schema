package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import java.util.Optional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.AnimalCertification;

public class ImpPortOfExitValidator implements ConstraintValidator<ImpPortOfExit, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    return Optional.ofNullable(partOne)
        .map(PartOne::getCommodities)
        .map(
            commodities ->
                commodities.getAnimalsCertifiedAs() != AnimalCertification.TRANSIT
                    || StringUtils.isNotBlank(partOne.getPortOfExit()))
        .orElse(false);
  }
}
