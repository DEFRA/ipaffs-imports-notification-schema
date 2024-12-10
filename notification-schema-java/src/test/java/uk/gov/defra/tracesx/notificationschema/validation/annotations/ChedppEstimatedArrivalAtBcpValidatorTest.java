package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.StatusEnum;

@ExtendWith(MockitoExtension.class)
class ChedppEstimatedArrivalAtBcpValidatorTest {

  private final Notification notification = new Notification();
  private ChedppEstimatedArrivalAtBcpValidator validator;

  @BeforeEach
  void setup() {
    notification.setPartOne(new PartOne());
    notification.setStatus(StatusEnum.VALIDATED);
    validator = new ChedppEstimatedArrivalAtBcpValidator();
  }

  @Test
  void givenNoPartOneWhenValidatorCalledThenValidatorReturnsFalse() {
    notification.setPartOne(null);
    Boolean result = validator.isValid(notification, null);

    assertThat(result).isFalse();
  }


  @Test
  void givenNotificationStatusInProgressWhenValidatorCalledThenValidatorReturnsTrue() {
    notification.getPartOne().setArrivalDate(LocalDate.now().minusDays(1));
    notification.getPartOne().setArrivalTime(LocalTime.now());
    notification.setStatus(StatusEnum.IN_PROGRESS);

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isTrue();
  }

  @Test
  void givenNotificationStatusSubmittedWhenValidatorCalledThenValidatorReturnsTrue() {
    notification.getPartOne().setArrivalDate(LocalDate.now().minusDays(1));
    notification.getPartOne().setArrivalTime(LocalTime.now());
    notification.setStatus(StatusEnum.SUBMITTED);

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isTrue();
  }

  @Test
  void givenANullArrivalTimeWhenValidatorCalledThenValidatorReturnsTrue() {
    notification.getPartOne().setArrivalDate(LocalDate.now());
    notification.getPartOne().setArrivalTime(null);

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isTrue();
  }

  @Test
  void givenANullArrivalTimeAndArrivalDateWhenValidatorCalledThenValidatorReturnsTrue() {
    notification.getPartOne().setArrivalDate(null);
    notification.getPartOne().setArrivalTime(null);

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isTrue();
  }

  @Test
  void givenArrivalDateInTheFutureWhenValidatorCalledThenValidatorReturnsTrue() {
    notification.getPartOne().setArrivalDate(LocalDate.now().plusDays(1));
    notification.getPartOne().setArrivalTime(LocalTime.now());

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isTrue();
  }

  @Test
  void givenArrivalDateOfTodayAndArrivalTimeInTheFutureWhenValidatorCalledThenValidatorReturnsTrue() {
    notification.getPartOne().setArrivalDate(LocalDate.now());
    notification.getPartOne().setArrivalTime(LocalTime.now().plusHours(1));

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isTrue();
  }

  @Test
  void givenArrivalDateInThePastWhenValidatorCalledThenValidatorReturnsFalse() {
    notification.getPartOne().setArrivalDate(LocalDate.now().minusDays(1));
    notification.getPartOne().setArrivalTime(LocalTime.now());

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isFalse();
  }

  @Test
  void givenArrivalDateOfTodayAndArrivalTimeInThePastWhenValidatorCalledThenValidatorReturnsFalse() {
    notification.getPartOne().setArrivalDate(LocalDate.now());
    notification.getPartOne().setArrivalTime(LocalTime.now().minusHours(1));

    Boolean result = validator.isValid(notification, null);

    assertThat(result).isFalse();
  }
}
