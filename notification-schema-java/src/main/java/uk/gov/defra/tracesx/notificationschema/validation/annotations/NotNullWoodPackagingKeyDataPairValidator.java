package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullWoodPackagingKeyDataPairValidator implements
    ConstraintValidator<NotNullWoodPackagingKeyDataPair, Commodities> {

  private String fieldName;

  @Override
  public void initialize(NotNullWoodPackagingKeyDataPair constraintAnnotation) {
    this.fieldName = constraintAnnotation.field();
  }

  @Override
  public boolean isValid(Commodities commodities, ConstraintValidatorContext context) {
    if (commodities == null
        || commodities.getCommodityComplement() == null
        || commodities.getComplementParameterSet() == null) {
      return true;
    }

    return commodities.getCommodityComplement().stream()
        .filter(commodityComplement -> commodityComplement.getIsWoodPackaging() != null
            && commodityComplement.getIsWoodPackaging().equals(true))
        .allMatch(commodityComplement -> {
          boolean exists = commodities.getComplementParameterSet().stream()
              .filter(complementParameterSet -> complementParameterSet.getComplementID() != null
                  && complementParameterSet.getSpeciesID() != null)
              .anyMatch(complementParameterSet ->
                  complementParameterSet.getComplementID().equals(
                      commodityComplement.getComplementID())
                      && complementParameterSet.getSpeciesID()
                      .equals(commodityComplement.getSpeciesID()));

          if (exists) {
            return commodities.getComplementParameterSet().stream()
                .filter(complementParameterSet -> complementParameterSet.getComplementID() != null
                    && complementParameterSet.getSpeciesID() != null)
                .filter(complementParameterSet -> complementParameterSet.getComplementID()
                    .equals(commodityComplement.getComplementID())
                    && complementParameterSet.getSpeciesID()
                    .equals(commodityComplement.getSpeciesID()))
                .allMatch(this::hasField);
          } else {
            return false;
          }
        });
  }

  private boolean hasField(ComplementParameterSet parameterSet) {
    List<ComplementParameterSetKeyDataPair> keyDataPairs = parameterSet.getKeyDataPair();
    return keyDataPairs != null && keyDataPairs.stream()
        .anyMatch(pair -> pair.getKey().equals(this.fieldName)
            && StringUtils.isNotEmpty(pair.getData()));
  }
}
