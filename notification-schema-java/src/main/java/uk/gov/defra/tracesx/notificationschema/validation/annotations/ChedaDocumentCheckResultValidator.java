package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.validation.utils.ConsignmentCheckUtil.isExistingCHEDANotification;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

public class ChedaDocumentCheckResultValidator implements
    ConstraintValidator<ChedaDocumentCheckResult, ConsignmentCheck> {

  @Override
  public boolean isValid(ConsignmentCheck consignmentCheck, ConstraintValidatorContext context) {
    if (consignmentCheck != null && !isExistingCHEDANotification(consignmentCheck)) {
      return (consignmentCheck.getEuStandard() == NOT_SET
          && consignmentCheck.getNationalRequirements() == NOT_SET
          && (consignmentCheck.getDocumentCheckResult() == SATISFACTORY
          || consignmentCheck.getDocumentCheckResult() == NOT_SATISFACTORY));
    }

    return true;
  }

  @Override
  public void initialize(ChedaDocumentCheckResult constraintAnnotation) {
    // no action
  }
}
