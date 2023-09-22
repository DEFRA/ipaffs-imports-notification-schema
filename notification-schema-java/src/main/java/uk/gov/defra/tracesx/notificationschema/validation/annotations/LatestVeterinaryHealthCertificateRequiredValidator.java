package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import java.util.Collection;
import java.util.Optional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
import uk.gov.defra.tracesx.notificationschema.representation.JourneyRiskCategorisation;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType;

public class LatestVeterinaryHealthCertificateRequiredValidator
    implements ConstraintValidator<LatestVeterinaryHealthCertificateRequired, Notification> {

  private static final String RISK_LEVEL_HIGH = "High";
  private static final String RISK_LEVEL_MEDIUM = "Medium";

  private boolean isMediumOrHighRiskConsignment(
      JourneyRiskCategorisation journeyRiskCategorisation) {

    return Optional.ofNullable(journeyRiskCategorisation)
      .map(JourneyRiskCategorisation::getRiskLevel)
      .map(riskLevel -> riskLevel.equals(RISK_LEVEL_HIGH) || riskLevel.equals(RISK_LEVEL_MEDIUM))
      .orElse(false);
  }

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
  public boolean isValid(Notification notification,
      ConstraintValidatorContext constraintValidatorContext) {

    VeterinaryInformation veterinaryInformation =
        notification.getPartOne().getVeterinaryInformation();
    JourneyRiskCategorisation journeyRiskCategorisation =
        notification.getJourneyRiskCategorisation();

    if (isMediumOrHighRiskConsignment(journeyRiskCategorisation)) {
      return hasLatestVeterinaryHealthCertificate(veterinaryInformation);
    } else {
      return true;
    }
  }
}
