package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PurposeGroupEnum;

public class PortOfExitAndExitBipNotEmptyValidator implements
    ConstraintValidator<PortOfExitAndExitBipNotEmpty, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    if (!isCandidateForValidation(partOne)) {
      return true;
    }
    return !StringUtils.isBlank(partOne.getPortOfExit())
        && !StringUtils.isBlank(partOne.getPurpose().getExitBIP());
  }

  private boolean isCandidateForValidation(PartOne partOne) {
    return partOne != null
        && partOne.getPurpose() != null
        && (isTemporaryAdmissionHorses(partOne) || isTransit(partOne));
  }

  private boolean isTemporaryAdmissionHorses(PartOne partOne) {
    return ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES.equals(
        partOne.getPurpose().getForImportOrAdmission()
    );
  }

  private boolean isTransit(PartOne partOne) {
    return PurposeGroupEnum.TRANSIT_TO_3RD_COUNTRY.equals(
        partOne.getPurpose().getPurposeGroup()
    );
  }
}
