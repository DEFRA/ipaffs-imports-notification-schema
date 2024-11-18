package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;

public class AccompanyingDocumentsValidator implements
    ConstraintValidator<AccompanyingDocuments, Notification> {

  @Override
  public void initialize(AccompanyingDocuments constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(Notification notification,
      ConstraintValidatorContext constraintValidatorContext) {

    if (notification.isCvedp()) {
      return true;
    }

    return veterinaryInformationPopulated(notification) || partTwoDocumentsPopulated(notification);
  }

  private boolean veterinaryInformationPopulated(Notification notification) {
    return !Optional.ofNullable(notification.getPartOne().getVeterinaryInformation())
        .map(VeterinaryInformation::getAccompanyingDocuments)
        .map(List::isEmpty)
        .orElse(true);
  }

  private boolean partTwoDocumentsPopulated(Notification notification) {
    return !Optional.ofNullable(notification.getPartTwo().getAccompanyingDocuments())
        .map(List::isEmpty)
        .orElse(true);
  }

}
