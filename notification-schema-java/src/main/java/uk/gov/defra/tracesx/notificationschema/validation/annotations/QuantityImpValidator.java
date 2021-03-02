package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ImpQuantityDataKeys;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class QuantityImpValidator
    implements ConstraintValidator<QuantityImp, List<ComplementParameterSet>> {

  private static final String IMP_WEIGHT_ERROR_MESSAGE = "Weight must be entered";
  private HibernateConstraintValidatorContext hibernateContext;

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

    hibernateContext = context.unwrap(
        HibernateConstraintValidatorContext.class
    );

    return complementParameterSets.stream()
        .allMatch(this::keyDataPairNotNullAndContainsQuantityData);
  }

  private boolean keyDataPairNotNullAndContainsQuantityData(
      ComplementParameterSet complementParameterSet) {
    return complementParameterSet.getKeyDataPair() != null
        && complementParameterSet.getKeyDataPair().stream()
        .anyMatch(this::hasAnyQuantityDataThatsNotEmpty);
  }

  private boolean hasAnyQuantityDataThatsNotEmpty(ComplementParameterSetKeyDataPair keyDataPair) {
    List<String> nonEmptyQuantities = Arrays.stream(ImpQuantityDataKeys.values())
         .map(ImpQuantityDataKeys::getValue)
         .filter(value -> value.equals(keyDataPair.getKey())
            && StringUtils.isNotEmpty(keyDataPair.getData()))
         .collect(Collectors.toList());

    if (!nonEmptyQuantities.isEmpty()) {
      return true;
    } else if (keyDataPair.getKey() != null && keyDataPair.getKey()
        .equals(ImpQuantityDataKeys.WEIGHT.getValue())) {
      changeValidationMessageForImpWeight();
    }
    return false;
  }

  private void changeValidationMessageForImpWeight() {
    hibernateContext.disableDefaultConstraintViolation();
    hibernateContext
        .buildConstraintViolationWithTemplate(IMP_WEIGHT_ERROR_MESSAGE)
        .addConstraintViolation();
  }
}
