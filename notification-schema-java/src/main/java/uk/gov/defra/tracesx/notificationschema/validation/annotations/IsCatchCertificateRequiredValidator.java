package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.List;
import java.util.Optional;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.CommodityComplement;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.VeterinaryInformation;

public class IsCatchCertificateRequiredValidator
    implements ConstraintValidator<IsCatchCertificateRequired, PartOne> {
  private static final List<String> NON_SPS_IUU_COMMODITY_CODE_PREFIXES = List.of(
      "03", "1604", "1605");

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext constraintValidatorContext) {
    if (partOne != null && partOne.getIsCatchCertificateRequired() != null
        && !partOne.getIsCatchCertificateRequired()) {
      return true;
    }
    boolean isNonSpsIuuCommodity = Optional.ofNullable(partOne)
        .map(PartOne::getCommodities)
        .map(Commodities::getCommodityComplement)
        .orElse(List.of())
        .stream()
        .anyMatch(this::isNonSpsIuuCommodity);

    int totalCertificates =
        Optional.ofNullable(partOne)
            .map(PartOne::getVeterinaryInformation)
            .map(VeterinaryInformation::getCatchCertificateAttachments)
            .orElse(List.of())
            .stream()
            .mapToInt(attachment ->
                attachment != null
                    ? Optional.ofNullable(attachment.getNumberOfCatchCertificates()).orElse(0)
                    : 0)
            .sum();
    return !isNonSpsIuuCommodity || totalCertificates > 0;
  }

  private boolean isNonSpsIuuCommodity(CommodityComplement commodityComplement) {
    return Optional.ofNullable(commodityComplement)
        .map(CommodityComplement::getCommodityID)
        .map(id -> NON_SPS_IUU_COMMODITY_CODE_PREFIXES.stream()
            .anyMatch(id::startsWith))
        .orElse(false);
  }
}
