package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotificationTypeEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.StatusEnum;

class ValidStatusValidatorTest {

  @Test
  void alwaysValidIfDraftStatus() {
    ValidStatusValidator statusValidator = new ValidStatusValidator();
    ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);
    Notification notification = new Notification();
    notification.setStatus(StatusEnum.DRAFT);

    boolean valid = statusValidator.isValid(notification, mockContext);

    assertThat(valid).isTrue();
  }

  @Test
  void invalidIfNoTypeAndNotInDraftStatus() {
    ValidStatusValidator statusValidator = new ValidStatusValidator();
    ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);
    Notification notification = new Notification();
    notification.setStatus(StatusEnum.SUBMITTED);

    boolean valid = statusValidator.isValid(notification, mockContext);

    assertThat(valid).isFalse();
  }

  @Test
  void validIfHasTypeAndNotInDraftStatus() {
    ValidStatusValidator statusValidator = new ValidStatusValidator();
    ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);
    Notification notification = new Notification();
    notification.setStatus(StatusEnum.SUBMITTED);
    notification.setType(NotificationTypeEnum.CED);

    boolean valid = statusValidator.isValid(notification, mockContext);

    assertThat(valid).isTrue();
  }

  @Test
  void statusCannotBeNull() {
    ValidStatusValidator statusValidator = new ValidStatusValidator();
    ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);
    Notification notification = new Notification();

    boolean valid = statusValidator.isValid(notification, mockContext);

    assertThat(valid).isFalse();
  }
}
