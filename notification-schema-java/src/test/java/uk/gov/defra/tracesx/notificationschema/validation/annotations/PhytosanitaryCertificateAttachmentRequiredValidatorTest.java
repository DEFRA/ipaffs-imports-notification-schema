package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType.PHYTOSANITARY_CERTIFICATE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType.VETERINARY_HEALTH_CERTIFICATE;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;

import java.util.UUID;

public class PhytosanitaryCertificateAttachmentRequiredValidatorTest {

  private PhytosanitaryCertificateAttachmentRequiredValidator validator;

  @Before
  public void setUp() {
    validator = new PhytosanitaryCertificateAttachmentRequiredValidator();
  }

  @Test
  public void isValid_returnsTrue_whenDocumentTypeNull() {
    // Given
    AccompanyingDocument accompanyingDocument = AccompanyingDocument.builder().build();

    // When
    boolean result = validator.isValid(accompanyingDocument, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void isValid_returnsTrue_whenNotPhytosanitaryCertificate() {
    // Given
    AccompanyingDocument accompanyingDocument = AccompanyingDocument.builder()
        .documentType(VETERINARY_HEALTH_CERTIFICATE)
        .build();

    // When
    boolean result = validator.isValid(accompanyingDocument, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void isValid_returnsFalse_whenAttachmentNotPresent() {
    // Given
    AccompanyingDocument accompanyingDocument = AccompanyingDocument.builder()
        .documentType(PHYTOSANITARY_CERTIFICATE)
        .build();

    // When
    boolean result = validator.isValid(accompanyingDocument, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  public void isValid_returnsTrue_whenAttachmentPresent() {
    // Given
    AccompanyingDocument accompanyingDocument = AccompanyingDocument.builder()
        .documentType(PHYTOSANITARY_CERTIFICATE)
        .attachmentId(UUID.randomUUID())
        .build();

    // When
    boolean result = validator.isValid(accompanyingDocument, null);

    // Then
    assertThat(result).isTrue();
  }
}
