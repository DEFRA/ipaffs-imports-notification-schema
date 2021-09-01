package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;

import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class HighRiskEUDocumentCheckResultValidator
    implements ConstraintValidator<HighRiskEUDocumentCheckResult, ConsignmentCheck> {

  @Override
  public void initialize(HighRiskEUDocumentCheckResult constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(
      ConsignmentCheck consignmentCheck, ConstraintValidatorContext context) {

    if (consignmentCheck == null) {
      return true;
    }

    return consignmentCheck.getDocumentCheckResult() != NOT_SET;
  }
}
