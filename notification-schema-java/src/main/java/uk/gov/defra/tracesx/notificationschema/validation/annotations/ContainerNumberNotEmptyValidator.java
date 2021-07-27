package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.NotificationSealsContainers;

import java.util.List;
import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContainerNumberNotEmptyValidator
    implements ConstraintValidator<ContainerNumberNotEmpty, List<NotificationSealsContainers>> {

  @Override
  public void initialize(ContainerNumberNotEmpty constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(List<NotificationSealsContainers> notificationSealsContainers,
      ConstraintValidatorContext context) {
    if (notificationSealsContainers == null || notificationSealsContainers.isEmpty()) {
      return true;
    }

    return notificationSealsContainers.stream()
        .filter(Objects::nonNull)
        .noneMatch(container -> StringUtils.isBlank(container.getContainerNumber()));
  }
}
