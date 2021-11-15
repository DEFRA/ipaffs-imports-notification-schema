package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType.PHYTOSANITARY_CERTIFICATE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType.VETERINARY_HEALTH_CERTIFICATE;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class PhytosanitaryCertificateAttachmentRequiredValidatorTest {

  private PhytosanitaryCertificateAttachmentRequiredValidator validator;

  private PartOne partOne;

  @Before
  public void setUp() {
    validator = new PhytosanitaryCertificateAttachmentRequiredValidator();

    partOne =
        PartOne.builder()
            .commodities(
                Commodities.builder()
                    .isLowRiskArticle72Country(null)
                    .complementParameterSet(new ArrayList<>())
                    .build())
            .veterinaryInformation(
                VeterinaryInformation.builder().accompanyingDocuments(new ArrayList<>()).build())
            .build();
  }

  @Test
  public void isValid_returnsTrue_whenDocumentTypeNull() {
    // Given / When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void isValid_returnsTrue_whenNotPhytosanitaryCertificate() {
    // Given
    partOne
        .getVeterinaryInformation()
        .getAccompanyingDocuments()
        .add(AccompanyingDocument.builder().documentType(VETERINARY_HEALTH_CERTIFICATE).build());

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void isValid_returnsFalse_whenAttachmentNotPresent() {
    // Given
    partOne
        .getVeterinaryInformation()
        .getAccompanyingDocuments()
        .add(AccompanyingDocument.builder().documentType(PHYTOSANITARY_CERTIFICATE).build());

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  public void isValid_returnsTrue_whenAttachmentPresent() {
    // Given
    partOne
        .getVeterinaryInformation()
        .getAccompanyingDocuments()
        .add(
            AccompanyingDocument.builder()
                .documentType(PHYTOSANITARY_CERTIFICATE)
                .attachmentId(UUID.randomUUID())
                .build());

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void isValid_ReturnsTrue_WhenTheConsignmentIsArticle72() {
    // Given
    partOne.getCommodities().getComplementParameterSet().add(ComplementParameterSet.builder()
        .keyDataPair(Collections.singletonList(ComplementParameterSetKeyDataPair.builder()
            .key("low_risk_article72_commodity")
            .data("true")
            .build()))
        .build());

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }
}
