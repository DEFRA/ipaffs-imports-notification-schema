package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.StatusEnum;

import java.time.LocalDate;
import java.time.LocalTime;

@RunWith(MockitoJUnitRunner.class)
public class ChedppEstimatedArrivalAtBcpValidatorTest {

  private Notification notification = new Notification();
  private ChedppEstimatedArrivalAtBcpValidator validator;

  @Before
  public void setup() {
    notification.setPartOne(new PartOne());
    notification.setStatus(StatusEnum.VALIDATED);
    validator = new ChedppEstimatedArrivalAtBcpValidator();
  }

  @Test
  public void givenNoPartOneWhenValidatorCalledThenValidatorReturnsFalse() {
    notification.setPartOne(null);
    Boolean result = validator.isValid(notification, null);

    assertThat(result).isFalse();
  }


  @Test
  public void givenNotificationStatusInProgressWhenValidatorCalledThenValidatorReturnsTrue() {
    notification.getPartOne().setArrivalDate(LocalDate.now().minusDays(1));
    notification.getPartOne().setArrivalTime(LocalTime.now());
    notification.setStatus(StatusEnum.IN_PROGRESS);

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isTrue();
  }

  @Test
  public void givenNotificationStatusSubmittedWhenValidatorCalledThenValidatorReturnsTrue() {
    notification.getPartOne().setArrivalDate(LocalDate.now().minusDays(1));
    notification.getPartOne().setArrivalTime(LocalTime.now());
    notification.setStatus(StatusEnum.SUBMITTED);

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isTrue();
  }

  @Test
  public void givenANullArrivalTimeWhenValidatorCalledThenValidatorReturnsTrue() {
    notification.getPartOne().setArrivalDate(LocalDate.now());
    notification.getPartOne().setArrivalTime(null);

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isTrue();
  }

  @Test
  public void givenANullArrivalTimeAndArrivalDateWhenValidatorCalledThenValidatorReturnsTrue() {
    notification.getPartOne().setArrivalDate(null);
    notification.getPartOne().setArrivalTime(null);

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isTrue();
  }

  @Test
  public void givenArrivalDateInTheFutureWhenValidatorCalledThenValidatorReturnsTrue() {
    notification.getPartOne().setArrivalDate(LocalDate.now().plusDays(1));
    notification.getPartOne().setArrivalTime(LocalTime.now());

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isTrue();
  }

  @Test
  public void givenArrivalDateOfTodayAndArrivalTimeInTheFutureWhenValidatorCalledThenValidatorReturnsTrue() {
    notification.getPartOne().setArrivalDate(LocalDate.now());
    notification.getPartOne().setArrivalTime(LocalTime.now().plusHours(1));

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isTrue();
  }

  @Test
  public void givenArrivalDateInThePastWhenValidatorCalledThenValidatorReturnsFalse() {
    notification.getPartOne().setArrivalDate(LocalDate.now().minusDays(1));
    notification.getPartOne().setArrivalTime(LocalTime.now());

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isFalse();
  }

  @Test
  public void givenArrivalDateOfTodayAndArrivalTimeInThePastWhenValidatorCalledThenValidatorReturnsFalse() {
    notification.getPartOne().setArrivalDate(LocalDate.now());
    notification.getPartOne().setArrivalTime(LocalTime.now().minusHours(1));

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isFalse();
  }
}
