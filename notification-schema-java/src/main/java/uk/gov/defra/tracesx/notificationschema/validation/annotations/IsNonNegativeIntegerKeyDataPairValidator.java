package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

public class IsNonNegativeIntegerKeyDataPairValidator
    implements
    ConstraintValidator<IsNonNegativeIntegerKeyDataPair, List<ComplementParameterSetKeyDataPair>> {

  private IsNonNegativeIntegerKeyDataPairValidation validation;

  @Override
  public void initialize(IsNonNegativeIntegerKeyDataPair constraintAnnotation) {
    this.validation = new IsNonNegativeIntegerKeyDataPairValidation(constraintAnnotation.field());
  }

  @Override
  public boolean isValid(
      List<ComplementParameterSetKeyDataPair> keyDataPairList, ConstraintValidatorContext context) {
    return validation.isValid(keyDataPairList);
  }
}
