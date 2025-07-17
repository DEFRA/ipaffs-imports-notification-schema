package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
import uk.gov.defra.tracesx.notificationschema.representation.CatchCertificateAttachment;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.CommodityComplement;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType;

import java.time.LocalDate;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class IsCatchCertificateRequiredValidatorTest {

  private IsCatchCertificateRequiredValidator validator;

  private PartOne partOne;

  @BeforeEach
  void setUp() {
    validator = new IsCatchCertificateRequiredValidator();
    partOne = new PartOne();
  }

  @Test
  void shouldReturnTrueIfPartOneIsNull() {
    partOne = null;

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  void shouldReturnTrueIfCommoditiesIsNull() {
    partOne.setCommodities(null);

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }
  @Test
  void shouldReturnFalseIfNonSpsIuuCommodityAndCatchCertificateIsNotPresent() {
    partOne.setCommodities(Commodities.builder()
        .commodityComplement(asList(CommodityComplement.builder().commodityID("0345678").build()))
        .build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }

  @Test
  void shouldReturnTrueIfNonSpsIuuCommodityAndCatchCertificateIsPresent() {
    partOne.setCommodities(Commodities.builder()
        .commodityComplement(asList(CommodityComplement.builder().commodityID("0345678").build()))
        .build());
    partOne.setVeterinaryInformation(
        VeterinaryInformation.builder().catchCertificateAttachments(asList(
            CatchCertificateAttachment.builder().numberOfCatchCertificates(1).build())).build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  void shouldReturnFalseIfNonSpsIuuCommodityAndAccompanyingDocumentIsPresentAndCatchCertificateNorPresent() {
    partOne.setCommodities(Commodities.builder()
        .commodityComplement(asList(CommodityComplement.builder().commodityID("03089050").build()))
        .build());
    partOne.setVeterinaryInformation(
        VeterinaryInformation.builder()
            .accompanyingDocuments(asList(AccompanyingDocument.builder().documentType(
                    DocumentType.COMMERCIAL_DOCUMENT).documentReference("123")
                .documentIssueDate(LocalDate.now()).build())).build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }


  @Test
  void shouldReturnTrueIfSpsIuuCommodityAndCatchCertificateIsNotPresent() {
    partOne.setCommodities(Commodities.builder()
        .commodityComplement(asList(CommodityComplement.builder().commodityID("123").build()))
        .build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  void shouldReturnTrueIfSpsIuuCommodityAndCatchCertificateIsPresent() {
    partOne.setCommodities(Commodities.builder()
        .commodityComplement(asList(CommodityComplement.builder().commodityID("123").build()))
        .build());
    partOne.setVeterinaryInformation(
        VeterinaryInformation.builder().catchCertificateAttachments(asList(
            CatchCertificateAttachment.builder().numberOfCatchCertificates(1).build())).build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }
  @Test
  void shouldReturnTrueIfCatchCertificateIsNotRequired() {
    partOne.setIsCatchCertificateRequired(false);

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }
}
