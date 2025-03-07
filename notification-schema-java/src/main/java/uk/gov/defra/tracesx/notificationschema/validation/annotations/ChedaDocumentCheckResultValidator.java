package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

public class ChedaDocumentCheckResultValidator implements
    ConstraintValidator<ChedaDocumentCheckResult, ConsignmentCheck> {

  @Override
  public boolean isValid(ConsignmentCheck consignmentCheck, ConstraintValidatorContext context) {
    if (consignmentCheck != null) {
      return consignmentCheck.getDocumentCheckResult() != null
          && consignmentCheck.getDocumentCheckResult() != NOT_SET;
    }

    return true;
  }

  @Override
  public void initialize(ChedaDocumentCheckResult constraintAnnotation) {
    // no action
  }
}
