package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotificationTypeEnum.CVEDA;

import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CvedaControlledDestinationValidator implements
    ConstraintValidator<CvedaControlledDestination, PartTwo> {

  @Override
  public boolean isValid(PartTwo partTwo, ConstraintValidatorContext constraintValidatorContext) {
    if (partTwo == null) {
      return true;
    }
    return partTwo.getControlledDestination() != null || !ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(partTwo.getDecision(), CVEDA);
  }
}