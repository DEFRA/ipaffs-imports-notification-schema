package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotificationTypeEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.StatusEnum;

public class ValidStatusValidatorTest {

  @Test
  public void alwaysValidIfDraftStatus() {
    ValidStatusValidator statusValidator = new ValidStatusValidator();
    ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);
    Notification notification = new Notification();
    notification.setStatus(StatusEnum.DRAFT);

    boolean valid = statusValidator.isValid(notification, mockContext);

    assertTrue(valid);
  }

  @Test
  public void invalidIfNoTypeAndNotInDraftStatus() {
    ValidStatusValidator statusValidator = new ValidStatusValidator();
    ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);
    Notification notification = new Notification();
    notification.setStatus(StatusEnum.SUBMITTED);

    boolean valid = statusValidator.isValid(notification, mockContext);

    assertFalse(valid);
  }

  @Test
  public void validIfHasTypeAndNotInDraftStatus() {
    ValidStatusValidator statusValidator = new ValidStatusValidator();
    ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);
    Notification notification = new Notification();
    notification.setStatus(StatusEnum.SUBMITTED);
    notification.setType(NotificationTypeEnum.CED);

    boolean valid = statusValidator.isValid(notification, mockContext);

    assertTrue(valid);
  }

  @Test
  public void statusCannotBeNull() {
    ValidStatusValidator statusValidator = new ValidStatusValidator();
    ConstraintValidatorContext mockContext = mock(ConstraintValidatorContext.class);
    Notification notification = new Notification();

    boolean valid = statusValidator.isValid(notification, mockContext);

    assertFalse(valid);
  }
}
