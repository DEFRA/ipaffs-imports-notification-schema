package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.apache.commons.lang3.StringUtils;

import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChedppCustomsReferenceRequiredValidator implements
    ConstraintValidator<ChedppCustomsReferenceRequired, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    if (partOne == null) {
      return false;
    }

    return !StringUtils.isBlank(partOne.getCustomsReferenceNumber());
  }
}