package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isEmpty;

import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullKeyDataPairValidator
    implements ConstraintValidator<NotNullKeyDataPair, List<ComplementParameterSetKeyDataPair>> {

  private String fieldName;

  @Override
  public void initialize(NotNullKeyDataPair constraintAnnotation) {
    this.fieldName = constraintAnnotation.field();
  }

  @Override
  public boolean isValid(
      List<ComplementParameterSetKeyDataPair> keyDataPairList, ConstraintValidatorContext context) {
    if (keyDataPairList == null) {
      return false;
    }
    for (ComplementParameterSetKeyDataPair keyDataPair : keyDataPairList) {
      String key = keyDataPair.getKey();
      if (isBlank(key)) {
        return false;
      }
      if (key.equals(fieldName)) {
        return !isEmpty(keyDataPair.getData());
      }
    }
    return false;
  }
}
