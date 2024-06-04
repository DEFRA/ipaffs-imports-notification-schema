package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

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
