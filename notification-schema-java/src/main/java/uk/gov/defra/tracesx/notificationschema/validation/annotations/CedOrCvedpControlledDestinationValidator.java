package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotificationTypeEnum.CED;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;

public class CedOrCvedpControlledDestinationValidator implements
    ConstraintValidator<CedOrCvedpControlledDestination, PartTwo> {

  @Override
  public boolean isValid(PartTwo partTwo, ConstraintValidatorContext constraintValidatorContext) {
    if (partTwo == null) {
      return true;
    }
    //it doesn't matter which of CED/CVEDP certificate type we use.
    return partTwo.getControlledDestination() != null || !ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(partTwo.getDecision(), CED);
  }
}
