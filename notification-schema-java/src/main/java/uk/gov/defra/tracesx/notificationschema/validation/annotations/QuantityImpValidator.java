package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ImpQuantityDataKeys;

import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class QuantityImpValidator
    implements ConstraintValidator<QuantityImp, List<ComplementParameterSet>> {

  @Override
  public void initialize(QuantityImp constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(List<ComplementParameterSet> complementParameterSets,
      ConstraintValidatorContext context) {
    if (complementParameterSets == null) {
      return true;
    }

    return complementParameterSets.stream()
        .allMatch(this::keyDataPairNotNullAndContainsQuantityData);
  }

  private boolean keyDataPairNotNullAndContainsQuantityData(
      ComplementParameterSet complementParameterSet) {
    return complementParameterSet.getKeyDataPair() != null
        && complementParameterSet.getKeyDataPair().stream()
        .anyMatch(this::hasAnyQuantityDataThatsNotEmpty);
  }

  private boolean hasAnyQuantityDataThatsNotEmpty(
      ComplementParameterSetKeyDataPair keyPair) {
    return Arrays.stream(ImpQuantityDataKeys.values())
        .anyMatch(key -> key.getValue().equals(keyPair.getKey())
            && StringUtils.isNotEmpty(keyPair.getData()));
  }
}
