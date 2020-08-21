package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NotNullVeterinaryDocumentValidatorTest {

  private NotNullVeterinaryDocumentValidator validator;

  @Before
  public void setUp() {
    validator = new NotNullVeterinaryDocumentValidator();
  }

  @Test
  public void givenVeterinaryInformationIsNull_whenICallIsValid_thenResultIsFalse() {
    assertFalse(validator.isValid(null, null));
  }

  @Test
  public void givenNoVeterinaryOrAccompanyingDocuments_whenICallIsValid_thenResultIsFalse() {
    VeterinaryInformation veterinaryInformation = new VeterinaryInformation();

    assertFalse(validator.isValid(veterinaryInformation, null));
  }

  @Test
  public void givenAVeterinaryDocument_whenICallIsValid_thenResultIsTrue() {
    VeterinaryInformation veterinaryInformation = new VeterinaryInformation();
    List<String> accompanyingDocumentNumbers = Collections.singletonList("DOC_NUM");
    veterinaryInformation.setAccompanyingDocumentNumbers(accompanyingDocumentNumbers);
    veterinaryInformation.setVeterinaryDocument("VET_DOC");

    assertTrue(validator.isValid(veterinaryInformation, null));
  }

  @Test
  public void givenAVeterinaryHealthCertificate_whenICallIsValid_thenResultIsTrue() {
    VeterinaryInformation veterinaryInformation = new VeterinaryInformation();
    List<AccompanyingDocument> accompanyingDocuments = new ArrayList<>();
    accompanyingDocuments.add(
        AccompanyingDocument.builder()
            .documentType(DocumentType.VETERINARY_HEALTH_CERTIFICATE)
            .documentReference("REF")
            .build());
    veterinaryInformation.setAccompanyingDocuments(accompanyingDocuments);

    assertTrue(validator.isValid(veterinaryInformation, null));
  }

  @Test
  public void givenAVeterinaryHealthCertificateWithNoReference_whenICallIsValid_thenResultIsFalse() {
    VeterinaryInformation veterinaryInformation = new VeterinaryInformation();
    List<AccompanyingDocument> accompanyingDocuments = new ArrayList<>();
    accompanyingDocuments.add(
        AccompanyingDocument.builder()
            .documentType(DocumentType.VETERINARY_HEALTH_CERTIFICATE)
            .build());
    veterinaryInformation.setAccompanyingDocuments(accompanyingDocuments);

    assertFalse(validator.isValid(veterinaryInformation, null));
  }
}
