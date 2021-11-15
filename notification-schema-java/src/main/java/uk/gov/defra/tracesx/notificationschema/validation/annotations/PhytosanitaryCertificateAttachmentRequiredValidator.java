package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType.PHYTOSANITARY_CERTIFICATE;

import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhytosanitaryCertificateAttachmentRequiredValidator
    implements ConstraintValidator<PhytosanitaryCertificateAttachmentRequired, PartOne> {

  private static final String ARTICLE_72_COMMODITY_KEY = "low_risk_article72_commodity";

  @Override
  public void initialize(PhytosanitaryCertificateAttachmentRequired constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {

    return isArticle72Consignment(partOne)
        || partOne.getVeterinaryInformation().getAccompanyingDocuments().stream()
            .filter(this::isPhytosanitaryCertificate)
            .findFirst()
            .map(this::hasAttachment)
            .orElse(true);
  }

  private boolean isPhytosanitaryCertificate(AccompanyingDocument accompanyingDocument) {
    return accompanyingDocument.getDocumentType() != null
        && accompanyingDocument.getDocumentType().equals(PHYTOSANITARY_CERTIFICATE);
  }

  private boolean hasAttachment(AccompanyingDocument accompanyingDocument) {
    return accompanyingDocument.getAttachmentId() != null;
  }

  private boolean isArticle72Commodity(List<ComplementParameterSetKeyDataPair> keyDataPairs) {
    return keyDataPairs.stream()
        .anyMatch(
            keyDataPair ->
                Objects.equals(keyDataPair.getKey(), ARTICLE_72_COMMODITY_KEY)
                    && Objects.equals(keyDataPair.getData(), "true"));
  }

  private boolean isArticle72Consignment(PartOne partOne) {
    return partOne.getCommodities().getComplementParameterSet().stream()
            .allMatch(parameterSet -> isArticle72Commodity(parameterSet.getKeyDataPair()))
        && Optional.ofNullable(partOne.getCommodities().getCountryOfOriginIsPodCountry())
            .orElse(false);
  }
}
