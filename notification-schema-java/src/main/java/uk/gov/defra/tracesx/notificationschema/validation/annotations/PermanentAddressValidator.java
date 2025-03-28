package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.CommodityComplement;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.Identifier;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

public class PermanentAddressValidator implements
    ConstraintValidator<PermanentAddress, PartOne> {

  private static final List<String> ANIMALS_REQUIRING_PERMANENT_ADDRESS = List.of("felis catus",
      "canis familiaris", "mustela putorius furio");

  @Override
  public boolean isValid(PartOne partOne, ConstraintValidatorContext context) {

    List<CommodityComplement> commodityComplements = Optional.ofNullable(partOne)
        .map(PartOne::getCommodities)
        .map(Commodities::getCommodityComplement)
        .orElse(Collections.emptyList());

    List<String> speciesIds = getSpeciesID(commodityComplements);

    List<ComplementParameterSet> parameterSets = Optional.ofNullable(partOne)
        .map(PartOne::getCommodities)
        .map(Commodities::getComplementParameterSet)
        .orElse(Collections.emptyList());

    if (speciesIds.isEmpty()) {
      return true;
    }

    return !parameterSets.isEmpty() && parameterSets.stream()
        .filter(parameterSet -> speciesIds.contains(parameterSet.getSpeciesID()))
        .allMatch(this::validateIdentifier);
  }

  private boolean validateIdentifier(ComplementParameterSet complementParameterSet) {
    if (complementParameterSet.getIdentifiers() != null
        && !complementParameterSet.getIdentifiers().isEmpty()) {
      return complementParameterSet.getIdentifiers().stream()
          .allMatch(this::validatePermanentAddress);
    }
    return false;
  }

  private boolean validatePermanentAddress(Identifier identifier) {
    if (Boolean.TRUE.equals(identifier.getIsPlaceOfDestinationThePermanentAddress())) {
      return true;
    } else if (identifier.getPermanentAddress() != null) {
      return identifier.getPermanentAddress().getAddress() != null;
    }
    return false;
  }

  private List<String> getSpeciesID(List<CommodityComplement> commodityComplements) {
    return commodityComplements.stream()
        .filter(cc -> cc.getSpeciesID() != null && cc.getSpeciesName() != null)
        .filter(
            cc -> ANIMALS_REQUIRING_PERMANENT_ADDRESS
                .contains(cc.getSpeciesName().toLowerCase()))
        .map(CommodityComplement::getSpeciesID).toList();
  }
}
