package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullCustomsReferenceNumberValidator implements
    ConstraintValidator<NotNullCustomsReferenceNumber, PartOne> {

  @Override
  public void initialize(NotNullCustomsReferenceNumber constraintAnnotation) {
    // No action
  }

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext context) {
    if (partOne == null) {
      return false;
    }
    return StringUtils.isNotBlank(partOne.getCustomsReferenceNumber());
  }
}
