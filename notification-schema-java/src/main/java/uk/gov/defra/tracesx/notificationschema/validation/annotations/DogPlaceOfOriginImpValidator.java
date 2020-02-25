package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DogPlaceOfOriginImpValidator
    implements ConstraintValidator<DogPlaceOfOriginImp, PartOne> {

  private static final String DOG_SPECIES_NAME = "Canis familiaris";

  @Override
  public void initialize(DogPlaceOfOriginImp constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext context) {
    if (partOne == null
        || partOne.getCommodities() == null
        || partOne.getCommodities().getCommodityComplement() == null) {
      return true;
    }
    return !isDogACommodityAndPlaceOfOriginNull(partOne);
  }

  private boolean isDogACommodityAndPlaceOfOriginNull(PartOne partOne) {
    return partOne.getCommodities().getCommodityComplement().stream()
        .anyMatch(commodityComplement -> commodityComplement.getSpeciesName() != null
            && commodityComplement.getSpeciesName().equals(DOG_SPECIES_NAME))
        && partOne.getConsignor() == null;
  }
}
