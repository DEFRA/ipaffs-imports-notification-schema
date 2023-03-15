package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

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

    return consignmentCheck.getDocumentCheckResult() != NOT_SET
        && consignmentCheck.getDocumentCheckResult()
            != SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION;
  }
}
