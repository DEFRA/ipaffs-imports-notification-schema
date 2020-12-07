package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullPurposeExitBipValidator implements
    ConstraintValidator<NotNullPurposeExitBip, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {

    if (partOne == null || partOne.getPurpose() == null) {
      return true;
    }

    Purpose purpose = partOne.getPurpose();

    if (purpose.getForImportOrAdmission() != null
        && purpose.getForImportOrAdmission()
        .equals(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES)) {
      return purpose.getExitBIP() != null;
    }

    return true;
  }
}
