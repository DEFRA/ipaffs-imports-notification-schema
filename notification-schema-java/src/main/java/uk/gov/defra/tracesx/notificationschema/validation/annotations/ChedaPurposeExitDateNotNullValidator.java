package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES;

import java.util.Optional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;

public class ChedaPurposeExitDateNotNullValidator
    implements ConstraintValidator<ChedaPurposeExitDateNotNull, Purpose> {

  @Override
  public boolean isValid(Purpose purpose, ConstraintValidatorContext context) {
    boolean isValid = Optional.ofNullable(purpose)
        .map(
            foundPurpose ->
                foundPurpose.getForImportOrAdmission() != TEMPORARY_ADMISSION_HORSES
                    || (foundPurpose.getForImportOrAdmission() == TEMPORARY_ADMISSION_HORSES
                        && foundPurpose.getExitDate() != null))
        .orElse(false);

    if (!isValid) {
      HibernateConstraintValidatorContext hibernateContext =
          context.unwrap(HibernateConstraintValidatorContext.class);
      hibernateContext.disableDefaultConstraintViolation();
      hibernateContext
          .buildConstraintViolationWithTemplate(
              "{uk.gov.defra.tracesx.notificationschema.representation.partone."
                  + "purpose.exitdate.not.null}")
          .addPropertyNode("exitdate")
          .addConstraintViolation();
    }

    return isValid;
  }
}
