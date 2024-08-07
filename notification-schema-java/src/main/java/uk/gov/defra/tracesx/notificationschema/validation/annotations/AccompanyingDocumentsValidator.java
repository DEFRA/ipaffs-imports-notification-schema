package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
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

    return (veterinaryInformation != null
        && veterinaryInformation.getAccompanyingDocuments() != null
        && !veterinaryInformation.getAccompanyingDocuments().isEmpty())
        || (partTwoDocuments != null && !partTwoDocuments.isEmpty());
  }
}
