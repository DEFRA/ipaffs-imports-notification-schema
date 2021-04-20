package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DocumentType.PHYTOSANITARY_CERTIFICATE;

import uk.gov.defra.tracesx.notificationschema.representation.AccompanyingDocument;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhytosanitaryCertificateRequiredValidator implements
    ConstraintValidator<PhytosanitaryCertificateRequired, PartOne> {

  private static final String REGULATORY_AUTHORITY = "regulatory_authority";
  private static final String JOINT = "JOINT";
  private static final String PHSI = "PHSI";

  private static boolean isRegulatoryAuthority(
      ComplementParameterSetKeyDataPair keyDataPair) {
    return keyDataPair.getKey() != null
        && keyDataPair.getKey().equals(REGULATORY_AUTHORITY);
  }

  private static boolean isPhsiOrJoint(ComplementParameterSetKeyDataPair keyDataPair) {
    return keyDataPair.getData() != null
        && (keyDataPair.getData().equals(PHSI) || keyDataPair.getData().equals(JOINT));
  }

  private static boolean hasPhsiOrJoint(PartOne partOne) {
    return Optional.of(partOne)
        .map(PartOne::getCommodities)
        .map(Commodities::getComplementParameterSet)
        .stream()
        .flatMap(Collection::stream)
        .map(ComplementParameterSet::getKeyDataPair)
        .flatMap(Collection::stream)
        .filter(Objects::nonNull)
        .filter(PhytosanitaryCertificateRequiredValidator::isRegulatoryAuthority)
        .anyMatch(PhytosanitaryCertificateRequiredValidator::isPhsiOrJoint);
  }

  private static boolean hasPhytosanitaryCertificate(PartOne partOne) {
    return Optional.of(partOne)
        .map(PartOne::getVeterinaryInformation)
        .map(VeterinaryInformation::getAccompanyingDocuments)
        .stream()
        .flatMap(Collection::stream)
        .map(AccompanyingDocument::getDocumentType)
        .anyMatch(documentType -> documentType.equals(PHYTOSANITARY_CERTIFICATE));
  }

  @Override
  public void initialize(PhytosanitaryCertificateRequired constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    if (hasPhsiOrJoint(partOne)) {
      return hasPhytosanitaryCertificate(partOne);
    } else {
      return true;
    }
  }
}
