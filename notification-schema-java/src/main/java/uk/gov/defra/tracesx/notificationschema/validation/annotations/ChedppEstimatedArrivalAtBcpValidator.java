package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChedppEstimatedArrivalAtBcpValidator implements
    ConstraintValidator<ChedppEstimatedArrivalAtBcp, PartOne> {

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    if (partOne == null) {
      return false;
    }

    LocalDate arrivalDate = partOne.getArrivalDate();
    LocalTime arrivalTime = partOne.getArrivalTime();

    if (arrivalDate != null && arrivalTime != null) {
      LocalDateTime arrivalDateTime = LocalDateTime.of(arrivalDate, arrivalTime);
      LocalDateTime currentDateTime = LocalDateTime.now();
      return arrivalDateTime.isAfter(currentDateTime);
    }

    return true;
  }
}