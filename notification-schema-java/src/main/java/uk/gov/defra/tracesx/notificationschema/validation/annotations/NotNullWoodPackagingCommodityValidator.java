package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.CommodityComplement;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullWoodPackagingCommodityValidator implements
    ConstraintValidator<NotNullWoodPackagingCommodity, PartOne> {

  @Override
  public void initialize(NotNullWoodPackagingCommodity constraintAnnotation) {
    // No action
  }

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext context) {
    if (partOne == null
        || partOne.getCommodities() == null
        || partOne.getCommodities().getCommodityComplement() == null
        || partOne.getContainsWoodPackaging() == null
        || !partOne.getContainsWoodPackaging()) {
      return true;
    }

    return hasWoodPackagingCommodity(partOne.getCommodities().getCommodityComplement());
  }

  private boolean hasWoodPackagingCommodity(List<CommodityComplement> commodityComplements) {
    return commodityComplements.stream().anyMatch(
        commodityComplement -> commodityComplement.getIsWoodPackaging() != null
            && commodityComplement.getIsWoodPackaging());
  }
}
