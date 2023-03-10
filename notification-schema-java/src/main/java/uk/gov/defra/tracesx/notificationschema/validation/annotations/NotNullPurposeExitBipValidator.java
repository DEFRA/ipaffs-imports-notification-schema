package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PurposeGroupEnum.TRANSIT_TO_3RD_COUNTRY;

import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;

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

    if (TEMPORARY_ADMISSION_HORSES.equals(purpose.getForImportOrAdmission())
        || TRANSIT_TO_3RD_COUNTRY.equals(purpose.getPurposeGroup())) {
      return purpose.getExitBIP() != null;
    }

    return true;
  }
}
