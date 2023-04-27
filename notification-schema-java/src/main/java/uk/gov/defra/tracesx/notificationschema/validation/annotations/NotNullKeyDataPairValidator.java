package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

public class NotNullKeyDataPairValidator
    implements ConstraintValidator<NotNullKeyDataPair, List<ComplementParameterSetKeyDataPair>> {

  private NotNullKeyDataPairValidation validation;

  @Override
  public void initialize(NotNullKeyDataPair constraintAnnotation) {
    this.validation = new NotNullKeyDataPairValidation(constraintAnnotation.field());
  }

  @Override
  public boolean isValid(
      List<ComplementParameterSetKeyDataPair> keyDataPairList, ConstraintValidatorContext context) {
    return validation.isValid(keyDataPairList);
  }
}
