package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

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
