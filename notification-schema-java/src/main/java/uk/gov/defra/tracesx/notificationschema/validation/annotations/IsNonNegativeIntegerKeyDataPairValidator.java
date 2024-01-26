package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
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
