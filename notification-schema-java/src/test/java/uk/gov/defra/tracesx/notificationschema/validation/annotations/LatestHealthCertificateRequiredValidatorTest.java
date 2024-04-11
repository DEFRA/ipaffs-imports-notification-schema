package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
import uk.gov.defra.tracesx.notificationschema.representation.JourneyRiskCategorisation;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType;

public class LatestHealthCertificateRequiredValidatorTest {

  private LatestHealthCertificateRequiredValidator validator;
  private VeterinaryInformation veterinaryInformation;


  @Before
  public void setup() {
    validator = new LatestHealthCertificateRequiredValidator();
    veterinaryInformation = new VeterinaryInformation();
    AccompanyingDocument accompanyingDocument = new AccompanyingDocument();
    accompanyingDocument.setDocumentReference("referenceNumber");
    accompanyingDocument.setDocumentIssueDate(LocalDate.now());
    accompanyingDocument.setDocumentType(DocumentType.LATEST_VETERINARY_HEALTH_CERTIFICATE);
    veterinaryInformation.setAccompanyingDocuments(Collections.singletonList(accompanyingDocument));
  }

  @Test
  public void isValid_ReturnsTrue_WhenContainsLatestHealthCertificate() {
    assertThat(validator.isValid(veterinaryInformation, null)).isTrue();
  }

  @Test
  public void isValid_ReturnsFalse_WhenDoesContainsLatestHealthCertificate() {
    veterinaryInformation.setAccompanyingDocuments(null);
    assertThat(validator.isValid(veterinaryInformation, null)).isFalse();
  }

  @Test
  public void isValid_ReturnsFalse_WhenContainsAccompanyingDocsButNotLatestHealthCertificate() {
    AccompanyingDocument accompanyingDocument = new AccompanyingDocument();
    accompanyingDocument.setDocumentReference("referenceNumber");
    accompanyingDocument.setDocumentIssueDate(LocalDate.now());
    accompanyingDocument.setDocumentType(DocumentType.AIR_WAYBILL);
    veterinaryInformation.setAccompanyingDocuments(Collections.singletonList(accompanyingDocument));
    assertThat(validator.isValid(veterinaryInformation, null)).isFalse();
  }

}
