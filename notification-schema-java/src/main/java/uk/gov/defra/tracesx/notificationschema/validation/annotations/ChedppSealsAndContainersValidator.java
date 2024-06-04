package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.NotificationSealsContainers;

public class ChedppSealsAndContainersValidator
    implements ConstraintValidator<ChedppSealsAndContainers, NotificationSealsContainers> {

  @Override
  public boolean isValid(NotificationSealsContainers notificationSealsContainers,
      ConstraintValidatorContext constraintValidatorContext) {
    if (notificationSealsContainers != null) {
      return !StringUtils.isEmpty(notificationSealsContainers.getContainerNumber())
          || !StringUtils.isEmpty(notificationSealsContainers.getSealNumber());
    }
    return true;
  }
}
