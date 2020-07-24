package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.CommodityComplement;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

import java.util.List;
import java.util.NoSuchElementException;
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

    return commodities.getComplementParameterSet().stream()
        .filter(parameterSet -> isWoodPackaging(parameterSet, commodities.getCommodityComplement()))
        .allMatch(this::hasField);
  }

  private boolean isWoodPackaging(ComplementParameterSet parameterSet,
      List<CommodityComplement> complements) {
    int complementID = parameterSet.getComplementID();
    String speciesID = parameterSet.getSpeciesID();

    Boolean isWoodPackaging = complements.stream()
        .filter(complement -> complement.getComplementID().equals(complementID)
            && complement.getSpeciesID().equals(speciesID))
        .findAny()
        .orElseThrow(() -> new NoSuchElementException("No matching commodity complement"))
        .getIsWoodPackaging();

    return isWoodPackaging != null && isWoodPackaging;
  }

  private boolean hasField(ComplementParameterSet parameterSet) {
    List<ComplementParameterSetKeyDataPair> keyDataPairs = parameterSet.getKeyDataPair();
    return keyDataPairs != null && keyDataPairs.stream()
        .anyMatch(pair -> pair.getKey().equals(this.fieldName)
            && StringUtils.isNotEmpty(pair.getData()));
  }
}
