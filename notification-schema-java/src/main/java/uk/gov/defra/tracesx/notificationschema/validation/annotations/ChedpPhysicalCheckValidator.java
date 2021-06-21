package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.TRUE;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChedpPhysicalCheckValidator
    implements ConstraintValidator<ChedpPhysicalCheck, PartTwo> {

  @Override
  public void initialize(ChedpPhysicalCheck constraintAnnotation) {
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
        isValid = partTwo.getConsignmentCheck().getPhysicalCheckResult() != null;
      }
    }

    if (!isValid) {
      HibernateConstraintValidatorContext hibernateContext =
          context.unwrap(HibernateConstraintValidatorContext.class);
      hibernateContext.disableDefaultConstraintViolation();
      hibernateContext
          .buildConstraintViolationWithTemplate(
              "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.consignmentcheck."
                  + "physicalcheck.not.null}")
          .addPropertyNode("consignmentcheck.physicalcheckdone")
          .addConstraintViolation();
    }

    return isValid;
  }
}
