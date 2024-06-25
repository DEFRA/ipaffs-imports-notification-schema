package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Collection;
import java.util.Optional;
import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType;

public class LatestHealthCertificateRequiredValidator
    implements ConstraintValidator<LatestHealthCertificateRequired, VeterinaryInformation> {

  private boolean hasLatestVeterinaryHealthCertificate(
      VeterinaryInformation veterinaryInformation) {

    return Optional.ofNullable(veterinaryInformation)
      .map(VeterinaryInformation::getAccompanyingDocuments)
      .stream()
      .flatMap(Collection::stream)
      .map(AccompanyingDocument::getDocumentType)
      .anyMatch(documentType -> documentType.equals(
        DocumentType.LATEST_VETERINARY_HEALTH_CERTIFICATE));
  }

  @Override
  public boolean isValid(VeterinaryInformation veterinaryInformation,
      ConstraintValidatorContext constraintValidatorContext) {
    return hasLatestVeterinaryHealthCertificate(veterinaryInformation);
  }

}
