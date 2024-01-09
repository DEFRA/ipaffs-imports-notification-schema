package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
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

    VeterinaryInformation veterinaryInformation =
        notification.getPartOne().getVeterinaryInformation();
    List<AccompanyingDocument> partTwoDocuments =
        notification.getPartTwo().getAccompanyingDocuments();

    return notification.isCvedp() == true || ((veterinaryInformation != null
        && veterinaryInformation.getAccompanyingDocuments() != null
        && !veterinaryInformation.getAccompanyingDocuments().isEmpty())
        || (partTwoDocuments != null && !partTwoDocuments.isEmpty()));
  }
}
