package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.StringUtils.isBlank;

public class MinValueKeyDataPairValidator
    implements ConstraintValidator<MinValueKeyDataPair, List<ComplementParameterSetKeyDataPair>> {

  private String fieldName;

  @Override
  public void initialize(MinValueKeyDataPair constraintAnnotation) {
    this.fieldName = constraintAnnotation.field();
  }

  @Override
  public boolean isValid(
      List<ComplementParameterSetKeyDataPair> keyDataPairList, ConstraintValidatorContext context) {
    if (keyDataPairList == null) {
      return true;
    }
    for (ComplementParameterSetKeyDataPair keyDataPair : keyDataPairList) {
      String key = keyDataPair.getKey();
      if (isBlank(key)) {
        return false;
      }
      if (key.equals(fieldName)) {
        String data = keyDataPair.getData();
        try {
          BigDecimal value =
              Optional.ofNullable(data)
                  .map(BigDecimal::new)
                  .orElseThrow(NumberFormatException::new);
          if (value.compareTo(BigDecimal.ZERO) > 0) {
            return true;
          }
        } catch (NumberFormatException exception) {
          return false;
        }
      }
    }
    return false;
  }
}
