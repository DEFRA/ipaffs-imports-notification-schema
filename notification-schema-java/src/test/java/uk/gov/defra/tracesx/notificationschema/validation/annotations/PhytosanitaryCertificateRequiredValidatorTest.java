package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType.PHYTOSANITARY_CERTIFICATE;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;

import java.util.ArrayList;
import java.util.List;

public class PhytosanitaryCertificateRequiredValidatorTest {

  private static final String REGULATORY_AUTHORITY = "regulatory_authority";
  private static final String JOINT = "JOINT";
  private static final String PHSI = "PHSI";
  private static final String HMI = "HMI";

  private PhytosanitaryCertificateRequiredValidator validator;

  @Before
  public void setUp() {
    validator = new PhytosanitaryCertificateRequiredValidator();
  }

  @Test
  public void isValid_returnsTrue_whenComplementParameterSetNull() {
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
  public void isValid_returnsTrue_whenKeyDataPairNull() {
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
  public void isValid_returnsTrue_whenKeyNull() {
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
  public void isValid_returnsTrue_whenDataNull() {
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
  public void isValid_returnsTrue_whenNoPhsiOrJointCommodities() {
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
  public void isValid_returnsFalse_whenVeterinaryInformationNull() {
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
  public void isValid_returnsFalse_whenAccompanyingDocumentsNull() {
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
  public void isValid_returnsFalse_whenPhsiAndNoPhytosanitaryCertificate() {
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
  public void isValid_returnsFalse_whenJointAndNoPhytosanitaryCertificate() {
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
  public void isValid_returnsTrue_whenPhsiAndPhytosanitaryCertificate() {
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
  public void isValid_returnsTrue_whenJointAndPhytosanitaryCertifiate() {
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
