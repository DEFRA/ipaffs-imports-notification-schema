package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MinValueKeyDataPairValidator
    implements ConstraintValidator<MinValueKeyDataPair, List<ComplementParameterSetKeyDataPair>> {

  private MinValueKeyDataPairValidation validation;

  @Override
  public void initialize(MinValueKeyDataPair constraintAnnotation) {
    this.validation = new MinValueKeyDataPairValidation(constraintAnnotation.field());
  }

  @Override
  public boolean isValid(
      List<ComplementParameterSetKeyDataPair> keyDataPairList, ConstraintValidatorContext context) {
    if (keyDataPairList == null) {
      return true;
    }
    return validation.isValid(keyDataPairList);
  }
}
