package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;

public class NotNullPurposeExitDateValidator implements
    ConstraintValidator<NotNullPurposeExitDate, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {

    if (partOne == null || partOne.getPurpose() == null) {
      return true;
    }

    Purpose purpose = partOne.getPurpose();

    if (TEMPORARY_ADMISSION_HORSES.equals(purpose.getForImportOrAdmission())) {
      return purpose.getExitDate() != null;
    }

    return true;
  }
}
