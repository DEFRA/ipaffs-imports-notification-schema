package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullVeterinaryDocumentValidator
    implements ConstraintValidator<NotNullVeterinaryDocument, VeterinaryInformation> {

  @Override
  public void initialize(NotNullVeterinaryDocument constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(VeterinaryInformation veterinaryInformation,
                         ConstraintValidatorContext context) {
    if (veterinaryInformation == null) {
      return false;
    } else if (StringUtils.isEmpty(veterinaryInformation.getVeterinaryDocument())
        && veterinaryInformation.getAccompanyingDocuments() == null) {
      return false;
    } else {
      if (StringUtils.isNotEmpty(veterinaryInformation.getVeterinaryDocument())) {
        return true;
      } else {
        return veterinaryInformation.getAccompanyingDocuments().stream()
            .anyMatch(accompanyingDocument -> accompanyingDocument.getDocumentType() != null
                && accompanyingDocument.getDocumentType()
                .equals(DocumentType.VETERINARY_HEALTH_CERTIFICATE)
                && StringUtils.isNotEmpty(accompanyingDocument.getDocumentReference()));
      }
    }
  }
}