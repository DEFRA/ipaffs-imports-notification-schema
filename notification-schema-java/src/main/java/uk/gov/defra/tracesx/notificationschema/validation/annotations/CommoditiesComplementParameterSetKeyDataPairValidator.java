package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.CommodityComplement;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public abstract class CommoditiesComplementParameterSetKeyDataPairValidator<A extends Annotation>
    implements ConstraintValidator<A, Commodities> {

  private ComplementParameterSetKeyDataPairValidator validation;

  @Override
  public void initialize(A constraintAnnotation) {
    this.validation = initializeValidator(constraintAnnotation);
  }

  abstract ComplementParameterSetKeyDataPairValidator initializeValidator(A constraintAnnotation);

  @Override
  public boolean isValid(Commodities commodities, ConstraintValidatorContext context) {
    if (commodities.getCommodityComplement() == null
        || commodities.getComplementParameterSet() == null) {
      return true;
    }

    List<CommodityComplement> commodityComplements =
        commodities.getCommodityComplement().stream()
            .filter(
                commodityComplement ->
                    !Boolean.TRUE.equals(commodityComplement.getIsWoodPackaging()))
            .collect(Collectors.toList());
    List<ComplementParameterSet> complementParameterSets =
        new ArrayList<>(commodityComplements.size());
    for (CommodityComplement complement : commodityComplements) {
      Optional<ComplementParameterSet> complementParameterSetOptional =
          commodities.getComplementParameterSet().stream()
              .filter(
                  complementParameterSet ->
                      complement.getComplementID() != null
                          && complement
                              .getComplementID()
                              .equals(complementParameterSet.getComplementID())
                          && complement.getSpeciesID() != null
                          && complement
                              .getSpeciesID()
                              .equals(complementParameterSet.getSpeciesID()))
              .findFirst();
      if (complementParameterSetOptional.isPresent()) {
        complementParameterSets.add(complementParameterSetOptional.get());
      } else {
        return false;
      }
    }

    return complementParameterSets.stream().allMatch(this::isKeyDataPairValid);
  }

  protected boolean isKeyDataPairValid(ComplementParameterSet complementParameterSet) {
    return validation.isValid(complementParameterSet.getKeyDataPair());
  }
}
