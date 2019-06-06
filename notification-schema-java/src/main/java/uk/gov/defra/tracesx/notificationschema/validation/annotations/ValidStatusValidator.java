package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.StatusEnum;

import java.util.Objects;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidStatusValidator implements ConstraintValidator<ValidStatus, Object> {

  @Override
  public void initialize(ValidStatus status) {
    // no action
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext context) {
    Notification notification = (Notification) value;

    return StatusEnum.DRAFT == notification.getStatus() || !Objects.isNull(notification.getType());
  }
}
