package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType.PHYTOSANITARY_CERTIFICATE;

import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhytosanitaryCertificateAttachmentRequiredValidator implements
    ConstraintValidator<PhytosanitaryCertificateAttachmentRequired, AccompanyingDocument> {

  private static boolean isPhytosanitaryCertificate(AccompanyingDocument accompanyingDocument) {
    return accompanyingDocument.getDocumentType() != null
        && accompanyingDocument.getDocumentType().equals(PHYTOSANITARY_CERTIFICATE);
  }

  private static boolean hasAttachment(AccompanyingDocument accompanyingDocument) {
    return accompanyingDocument.getAttachmentId() != null;
  }

  @Override
  public void initialize(PhytosanitaryCertificateAttachmentRequired constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(AccompanyingDocument accompanyingDocument,
      ConstraintValidatorContext constraintValidatorContext) {
    if (isPhytosanitaryCertificate(accompanyingDocument)) {
      return hasAttachment(accompanyingDocument);
    } else {
      return true;
    }
  }
}
