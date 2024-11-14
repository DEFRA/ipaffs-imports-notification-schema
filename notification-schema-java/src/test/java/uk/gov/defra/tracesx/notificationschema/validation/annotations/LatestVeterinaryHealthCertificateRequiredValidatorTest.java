package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
import uk.gov.defra.tracesx.notificationschema.representation.JourneyRiskCategorisation;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType;

import java.time.LocalDate;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LatestVeterinaryHealthCertificateRequiredValidatorTest {

  private LatestVeterinaryHealthCertificateRequiredValidator validator;
  private Notification notification;

  private static final String RISK_LEVEL_HIGH = "High";
  private static final String RISK_LEVEL_MEDIUM = "Medium";
  private static final String RISK_LEVEL_LOW = "Low";

  @BeforeEach
  void setup() {
    validator = new LatestVeterinaryHealthCertificateRequiredValidator();
    notification = new Notification();
    JourneyRiskCategorisation journeyRiskCategorisation = new JourneyRiskCategorisation();
    journeyRiskCategorisation.setRiskLevel(RISK_LEVEL_HIGH);
    AccompanyingDocument accompanyingDocument = new AccompanyingDocument();
    accompanyingDocument.setDocumentReference("referenceNumber");
    accompanyingDocument.setDocumentIssueDate(LocalDate.now());
    accompanyingDocument.setDocumentType(DocumentType.LATEST_VETERINARY_HEALTH_CERTIFICATE);
    VeterinaryInformation veterinaryInformation = new VeterinaryInformation();
    veterinaryInformation.setAccompanyingDocuments(Collections.singletonList(accompanyingDocument));
    notification.setJourneyRiskCategorisation(journeyRiskCategorisation);
    notification.setPartOne(new PartOne());
    notification.getPartOne().setVeterinaryInformation(veterinaryInformation);
  }

  @Test
  void isValid_ReturnsTrue_WhenRiskLevelHighAndContainsLatestHealthCertificate() {
    assertThat(validator.isValid(notification, null)).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenRiskLevelMediumAndContainsLatestHealthCertificate() {
    notification.getJourneyRiskCategorisation().setRiskLevel(RISK_LEVEL_MEDIUM);
    assertThat(validator.isValid(notification, null)).isTrue();
  }

  @Test
  void isValid_ReturnsFalse_WhenRiskLevelHighAndDoesNotContainLatestHealthCertificate() {
    notification.getPartOne().getVeterinaryInformation().getAccompanyingDocuments().get(0).
      setDocumentType(DocumentType.AIR_WAYBILL);
    assertThat(validator.isValid(notification, null)).isFalse();
  }

  @Test
  void isValid_ReturnsFalse_WhenRiskLevelMediumAndDoesNotContainLatestHealthCertificate() {
    notification.getJourneyRiskCategorisation().setRiskLevel(RISK_LEVEL_MEDIUM);
    notification.getPartOne().getVeterinaryInformation().setAccompanyingDocuments(null);
    assertThat(validator.isValid(notification, null)).isFalse();
  }

  @Test
  void isValid_ReturnsFalse_WhenRiskLevelMediumAndDocTypeIsNotLatestHealthCert() {
    notification.getJourneyRiskCategorisation().setRiskLevel(RISK_LEVEL_MEDIUM);
    notification.getPartOne().getVeterinaryInformation().getAccompanyingDocuments().get(0)
      .setDocumentType(DocumentType.AIR_WAYBILL);
    assertThat(validator.isValid(notification, null)).isFalse();
  }

  @Test
  void isValid_ReturnsTrue_WhenRiskLevelLowAndContainsLatestHealthCertificate() {
    notification.getJourneyRiskCategorisation().setRiskLevel(RISK_LEVEL_LOW);
    notification.getPartOne().getVeterinaryInformation().getAccompanyingDocuments().get(0)
            .setDocumentReference("LatestHealthCertificate");
    assertThat(validator.isValid(notification, null)).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenRiskLevelLowAndDoesNotContainLatestHealthCertificate() {
    notification.getJourneyRiskCategorisation().setRiskLevel(RISK_LEVEL_LOW);
    notification.getPartOne().getVeterinaryInformation().getAccompanyingDocuments().get(0).
            setDocumentType(DocumentType.AIR_WAYBILL);
    assertThat(validator.isValid(notification, null)).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenRiskLevelNotSetAndContainsLatestHealthCertificate() {
    notification.getJourneyRiskCategorisation().setRiskLevel(null);
    assertThat(validator.isValid(notification, null)).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenRiskLevelNotSetAndDoesNotContainLatestHealthCertificate() {
    notification.getJourneyRiskCategorisation().setRiskLevel(null);
    notification.getPartOne().getVeterinaryInformation().setAccompanyingDocuments(null);
    assertThat(validator.isValid(notification, null)).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenNoJourneyRiskCategorisationObjectExistsAndContainsLatestHealthCertificate() {
    notification.setJourneyRiskCategorisation(null);
    assertThat(validator.isValid(notification, null)).isTrue();
  }

  @Test
  void isValid_ReturnsFalse_WhenRiskLevelIsHighAndNoVeterinaryInformationExists() {
    notification.getPartOne().setVeterinaryInformation(null);
    assertThat(validator.isValid(notification, null)).isFalse();
  }

}
