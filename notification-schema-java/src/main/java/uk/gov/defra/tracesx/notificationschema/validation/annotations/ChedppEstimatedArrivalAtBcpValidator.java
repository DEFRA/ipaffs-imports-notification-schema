package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.StatusEnum;

public class ChedppEstimatedArrivalAtBcpValidator implements
    ConstraintValidator<ChedppEstimatedArrivalAtBcp, Notification> {

  @Override
  public boolean isValid(Notification notification,
      ConstraintValidatorContext constraintValidatorContext) {
    if (notification.getPartOne() == null) {
      return false;
    }

    LocalDate arrivalDate = notification.getPartOne().getArrivalDate();
    LocalTime arrivalTime = notification.getPartOne().getArrivalTime();

    if (arrivalDate != null && arrivalTime != null
        && !Set.of(StatusEnum.IN_PROGRESS, StatusEnum.SUBMITTED)
        .contains(notification.getStatus())) {
      LocalDateTime arrivalDateTime = LocalDateTime.of(arrivalDate, arrivalTime);
      LocalDateTime currentDateTime = LocalDateTime.now();
      return arrivalDateTime.isAfter(currentDateTime);
    }

    return true;
  }
}
