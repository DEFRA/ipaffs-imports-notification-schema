package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;

public class DocumentCheckResultValidator
    implements ConstraintValidator<DocumentCheckResult, ConsignmentCheck> {

  @Override
  public void initialize(DocumentCheckResult constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(ConsignmentCheck consignmentCheck, ConstraintValidatorContext context) {
    if (consignmentCheck == null) {
      return true;
    }
    return (consignmentCheck.getDocumentCheckResult() != NOT_SET);
  }
}
