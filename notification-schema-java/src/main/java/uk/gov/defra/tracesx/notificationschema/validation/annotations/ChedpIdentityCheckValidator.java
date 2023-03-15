package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.TRUE;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

public class ChedpIdentityCheckValidator
    implements ConstraintValidator<ChedpIdentityCheck, PartTwo> {

  @Override
  public void initialize(ChedpIdentityCheck constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(PartTwo partTwo, ConstraintValidatorContext context) {
    boolean isValid = false;

    if (partTwo != null && partTwo.getConsignmentCheck() != null) {
      if (partTwo.getConsignmentCheck().getDocumentCheckResult() == Result.NOT_SATISFACTORY
          && (partTwo.getDecision() == null
              || !TRUE.equals(partTwo.getDecision().getConsignmentAcceptable()))) {
        isValid = true;
      } else {
        isValid =
            partTwo.getConsignmentCheck().getIdentityCheckType() != null
                && partTwo.getConsignmentCheck().getIdentityCheckResult() != null;
      }
    }

    if (!isValid) {
      HibernateConstraintValidatorContext hibernateContext =
          context.unwrap(HibernateConstraintValidatorContext.class);
      hibernateContext.disableDefaultConstraintViolation();
      hibernateContext
          .buildConstraintViolationWithTemplate(
              "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck."
                  + "identitycheck.not.null}")
          .addPropertyNode("consignmentcheck.identitycheckdone")
          .addConstraintViolation();
    }

    return isValid;
  }
}
