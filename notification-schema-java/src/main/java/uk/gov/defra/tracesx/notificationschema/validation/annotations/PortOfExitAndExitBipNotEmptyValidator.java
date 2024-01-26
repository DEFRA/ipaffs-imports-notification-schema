package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;

public class PortOfExitAndExitBipNotEmptyValidator implements
    ConstraintValidator<PortOfExitAndExitBipNotEmpty, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    if (partOne == null) {
      return true;
    }

    if (partOne.getPurpose() == null
        || !ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES.equals(
        partOne.getPurpose().getForImportOrAdmission())) {
      return true;
    }

    return partOne.getPortOfExit() != null && !partOne.getPortOfExit().isBlank()
        && partOne.getPurpose().getExitBIP() != null
        && !partOne.getPurpose().getExitBIP().isBlank();
  }
}
