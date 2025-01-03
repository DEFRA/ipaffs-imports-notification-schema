package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType.PHYTOSANITARY_CERTIFICATE;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;

class PhytosanitaryCertificateRequiredValidatorTest {

  private static final String REGULATORY_AUTHORITY = "regulatory_authority";
  private static final String JOINT = "JOINT";
  private static final String PHSI = "PHSI";
  private static final String HMI = "HMI";

  private PhytosanitaryCertificateRequiredValidator validator;

  @BeforeEach
  void setUp() {
    validator = new PhytosanitaryCertificateRequiredValidator();
  }

  @Test
  void isValid_ReturnsTrue_WhenComplementParameterSetNull() {
    // Given
    PartOne partOne = PartOne.builder()
        .commodities(Commodities.builder().build())
        .build();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenKeyDataPairNull() {
    // Given
    List<ComplementParameterSetKeyDataPair> keyDataPairs = new ArrayList<>();
    keyDataPairs.add(ComplementParameterSetKeyDataPair.builder().build());
    keyDataPairs.add(null);
    PartOne partOne = PartOne.builder()
        .commodities(Commodities.builder()
            .complementParameterSet(List.of(
                ComplementParameterSet.builder()
                    .keyDataPair(keyDataPairs)
                    .build()))
            .build())
        .build();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenKeyNull() {
    // Given
    PartOne partOne = PartOne.builder()
        .commodities(Commodities.builder()
            .complementParameterSet(List.of(
                ComplementParameterSet.builder()
                    .keyDataPair(List.of(
                        ComplementParameterSetKeyDataPair.builder().build()))
                    .build()))
            .build())
        .build();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenDataNull() {
    // Given
    PartOne partOne = PartOne.builder()
        .commodities(Commodities.builder()
            .complementParameterSet(List.of(
                ComplementParameterSet.builder()
                    .keyDataPair(List.of(
                        ComplementParameterSetKeyDataPair.builder()
                            .key(REGULATORY_AUTHORITY)
                            .build()))
                    .build()))
            .build())
        .build();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenNoPhsiOrJointCommodities() {
    // Given
    PartOne partOne = PartOne.builder()
        .commodities(Commodities.builder()
            .complementParameterSet(List.of(
                ComplementParameterSet.builder()
                    .keyDataPair(List.of(
                        ComplementParameterSetKeyDataPair.builder()
                            .key(REGULATORY_AUTHORITY)
                            .data(HMI)
                            .build(),
                        ComplementParameterSetKeyDataPair.builder()
                            .key("some_other_key")
                            .build()))
                    .build()))
            .build())
        .build();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void isValid_ReturnsFalse_WhenVeterinaryInformationNull() {
    // Given
    PartOne partOne = PartOne.builder()
        .commodities(Commodities.builder()
            .complementParameterSet(List.of(
                ComplementParameterSet.builder()
                    .keyDataPair(List.of(
                        ComplementParameterSetKeyDataPair.builder()
                            .key(REGULATORY_AUTHORITY)
                            .data(PHSI)
                            .build()))
                    .build()))
            .build())
        .build();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void isValid_ReturnsFalse_WhenAccompanyingDocumentsNull() {
    // Given
    PartOne partOne = PartOne.builder()
        .commodities(Commodities.builder()
            .complementParameterSet(List.of(
                ComplementParameterSet.builder()
                    .keyDataPair(List.of(
                        ComplementParameterSetKeyDataPair.builder()
                            .key(REGULATORY_AUTHORITY)
                            .data(PHSI)
                            .build()))
                    .build()))
            .build())
        .veterinaryInformation(VeterinaryInformation.builder().build())
        .build();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void isValid_ReturnsFalse_WhenPhsiAndNoPhytosanitaryCertificate() {
    // Given
    PartOne partOne = PartOne.builder()
        .commodities(Commodities.builder()
            .complementParameterSet(List.of(
                ComplementParameterSet.builder()
                    .keyDataPair(List.of(
                        ComplementParameterSetKeyDataPair.builder()
                            .key(REGULATORY_AUTHORITY)
                            .data(PHSI)
                            .build()))
                    .build()))
            .build())
        .veterinaryInformation(VeterinaryInformation.builder()
            .accompanyingDocuments(List.of())
            .build())
        .build();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void isValid_ReturnsFalse_WhenJointAndNoPhytosanitaryCertificate() {
    // Given
    PartOne partOne = PartOne.builder()
        .commodities(Commodities.builder()
            .complementParameterSet(List.of(
                ComplementParameterSet.builder()
                    .keyDataPair(List.of(
                        ComplementParameterSetKeyDataPair.builder()
                            .key(REGULATORY_AUTHORITY)
                            .data(JOINT)
                            .build()))
                    .build()))
            .build())
        .veterinaryInformation(VeterinaryInformation.builder()
            .accompanyingDocuments(List.of())
            .build())
        .build();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void isValid_ReturnsTrue_WhenPhsiAndPhytosanitaryCertificate() {
    // Given
    PartOne partOne = PartOne.builder()
        .commodities(Commodities.builder()
            .complementParameterSet(List.of(
                ComplementParameterSet.builder()
                    .keyDataPair(List.of(
                        ComplementParameterSetKeyDataPair.builder()
                            .key(REGULATORY_AUTHORITY)
                            .data(PHSI)
                            .build()))
                    .build()))
            .build())
        .veterinaryInformation(VeterinaryInformation.builder()
            .accompanyingDocuments(List.of(
                AccompanyingDocument.builder().documentType(PHYTOSANITARY_CERTIFICATE).build()))
            .build())
        .build();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenJointAndPhytosanitaryCertifiate() {
    // Given
    PartOne partOne = PartOne.builder()
        .commodities(Commodities.builder()
            .complementParameterSet(List.of(
                ComplementParameterSet.builder()
                    .keyDataPair(List.of(
                        ComplementParameterSetKeyDataPair.builder()
                            .key(REGULATORY_AUTHORITY)
                            .data(JOINT)
                            .build()))
                    .build()))
            .build())
        .veterinaryInformation(VeterinaryInformation.builder()
            .accompanyingDocuments(List.of(
                AccompanyingDocument.builder().documentType(PHYTOSANITARY_CERTIFICATE).build()))
            .build())
        .build();

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }
}
