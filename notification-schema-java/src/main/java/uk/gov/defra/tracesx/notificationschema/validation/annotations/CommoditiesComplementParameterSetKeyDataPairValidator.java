package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.CommodityComplement;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;

public abstract class CommoditiesComplementParameterSetKeyDataPairValidator<A extends Annotation>
    implements ConstraintValidator<A, Commodities> {

  private ComplementParameterSetKeyDataPairValidator validation;

  @Override
  public void initialize(A constraintAnnotation) {
    this.validation = initializeValidator(constraintAnnotation);
  }

  abstract ComplementParameterSetKeyDataPairValidator initializeValidator(A constraintAnnotation);

  @Override
  public boolean isValid(
      Commodities commodities, ConstraintValidatorContext context) {
    if (isNullOrEmpty(commodities.getCommodityComplement())
        || isNullOrEmpty(commodities.getComplementParameterSet())) {
      return true;
    }

    List<Integer> commodityComplementIds = commodities.getCommodityComplement().stream()
        .filter(commodityComplement ->
            !Boolean.TRUE.equals(commodityComplement.getIsWoodPackaging()))
        .map(CommodityComplement::getComplementID)
        .collect(Collectors.toList());

    if (commodityComplementIds.isEmpty()) {
      return true;
    }

    return commodities.getComplementParameterSet().stream()
        .filter(cp -> commodityComplementIds.contains(cp.getComplementID()))
        .map(this::isKeyDataPairValid)
        .reduce(Boolean::logicalAnd)
        .orElse(false);
  }

  protected boolean isKeyDataPairValid(ComplementParameterSet complementParameterSet) {
    return validation.isValid(complementParameterSet.getKeyDataPair());
  }

  public static <T> boolean isNullOrEmpty(Collection<T> list) {
    return list == null || list.isEmpty();
  }
}
