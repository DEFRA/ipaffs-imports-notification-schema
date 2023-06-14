package uk.gov.defra.tracesx.notificationschema.representation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ExternalSystem;

public class AccompanyingDocumentsTest {

  @Test
  public void isClonedDocument_ReturnsTrue_whenExternalReferenceIsECERT() {
    AccompanyingDocument accompanyingDocument = AccompanyingDocument.builder()
        .externalReference(ExternalReference.builder().
            system(ExternalSystem.ECERT)
            .build())
        .build();
    assertThat(accompanyingDocument.isClonedDocument()).isTrue();
  }

  @Test
  public void isClonedDocument_ReturnsFalse_whenExternalReferenceIsNotECERT() {
    AccompanyingDocument accompanyingDocument = AccompanyingDocument.builder()
        .externalReference(ExternalReference.builder()
            .system(ExternalSystem.EPHYTO)
            .build())
        .build();
    assertThat(accompanyingDocument.isClonedDocument()).isFalse();
  }

  @Test
  public void isClonedDocument_ReturnsFalse_whenNoExternalReference() {
    AccompanyingDocument accompanyingDocument = AccompanyingDocument.builder()
        .build();
    assertThat(accompanyingDocument.isClonedDocument()).isFalse();
  }
}
