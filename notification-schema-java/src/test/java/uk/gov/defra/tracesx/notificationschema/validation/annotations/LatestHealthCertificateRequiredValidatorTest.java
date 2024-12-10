package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType;

class LatestHealthCertificateRequiredValidatorTest {

  private LatestHealthCertificateRequiredValidator validator;
  private VeterinaryInformation veterinaryInformation;


  @BeforeEach
  void setup() {
    validator = new LatestHealthCertificateRequiredValidator();
    veterinaryInformation = new VeterinaryInformation();
    AccompanyingDocument accompanyingDocument = new AccompanyingDocument();
    accompanyingDocument.setDocumentReference("referenceNumber");
    accompanyingDocument.setDocumentIssueDate(LocalDate.now());
    accompanyingDocument.setDocumentType(DocumentType.LATEST_VETERINARY_HEALTH_CERTIFICATE);
    veterinaryInformation.setAccompanyingDocuments(Collections.singletonList(accompanyingDocument));
  }

  @Test
  void isValid_ReturnsTrue_WhenContainsLatestHealthCertificate() {
    assertThat(validator.isValid(veterinaryInformation, null)).isTrue();
  }

  @Test
  void isValid_ReturnsFalse_WhenDoesContainsLatestHealthCertificate() {
    veterinaryInformation.setAccompanyingDocuments(null);
    assertThat(validator.isValid(veterinaryInformation, null)).isFalse();
  }

  @Test
  void isValid_ReturnsFalse_WhenContainsAccompanyingDocsButNotLatestHealthCertificate() {
    AccompanyingDocument accompanyingDocument = new AccompanyingDocument();
    accompanyingDocument.setDocumentReference("referenceNumber");
    accompanyingDocument.setDocumentIssueDate(LocalDate.now());
    accompanyingDocument.setDocumentType(DocumentType.AIR_WAYBILL);
    veterinaryInformation.setAccompanyingDocuments(Collections.singletonList(accompanyingDocument));
    assertThat(validator.isValid(veterinaryInformation, null)).isFalse();
  }

}
