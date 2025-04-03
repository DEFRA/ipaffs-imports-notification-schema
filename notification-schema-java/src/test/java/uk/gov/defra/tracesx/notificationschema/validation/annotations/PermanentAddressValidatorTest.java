package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.CommodityComplement;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.EconomicOperator;
import uk.gov.defra.tracesx.notificationschema.representation.EconomicOperatorAddress;
import uk.gov.defra.tracesx.notificationschema.representation.Identifier;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

class PermanentAddressValidatorTest {

  private PartOne partOne;
  private PermanentAddressValidator validator;

  @BeforeEach
  void setUp() {
    validator = new PermanentAddressValidator();
    Commodities commodities = Commodities.builder()
        .complementParameterSet(List.of(ComplementParameterSet.builder().build())).build();

    partOne = PartOne.builder().commodities(commodities).build();
  }

  @Test
  void testThatValidatorReturnsTrue_IfNullPassed() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrue_SpeciesNotCat_Dog_Ferret() {
    partOne.getCommodities().setCommodityComplement(
        List.of(CommodityComplement.builder()
            .speciesName("Not cat")
            .speciesID("123446")
            .build()));
    assertThat(validator.isValid(partOne, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrue_SpeciesIsCat_Dog_FerretAndPermanentAddressIsPlaceOfDestinationIsTrue() {
    Identifier identifier = Identifier.builder().isPlaceOfDestinationThePermanentAddress(true).build();

    partOne.getCommodities().setCommodityComplement(
        List.of(CommodityComplement.builder()
            .speciesName("Felis catus")
            .speciesID("3434343")
            .build()));
    partOne.getCommodities().setComplementParameterSet(
        List.of(ComplementParameterSet.builder()
            .speciesID("3434343")
            .identifiers(List.of(identifier))
            .build())
    );

    assertThat(validator.isValid(partOne, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrue_SpeciesIsCat_Dog_FerretAndOnlyPermanentAddressSet() {
    Identifier identifier = Identifier.builder()
        .permanentAddress(
            EconomicOperator.builder()
                .address(EconomicOperatorAddress.builder().build()).build()).build();

    partOne.getCommodities().setCommodityComplement(
        List.of(CommodityComplement.builder()
            .speciesName("Felis catus")
            .speciesID("3434343")
            .build()));
    partOne.getCommodities().setComplementParameterSet(
        List.of(ComplementParameterSet.builder()
            .speciesID("3434343")
            .identifiers(List.of(identifier))
            .build())
    );

    assertThat(validator.isValid(partOne, null)).isTrue();
  }

  @ParameterizedTest
  @CsvSource({"Felis catus, 3434343", "Canis familiaris, 1234567", "Mustela putorius furio, 987654"})
  void testThatValidatorReturnsFalse_SpeciesIsCatDogFerretAndPermanentAddressIsNotPlaceOfDestinationIsFalseAndAddressIsNull(String speciesName, String speciesID) {
    Identifier identifier = Identifier.builder()
        .permanentAddress(
            EconomicOperator.builder().build()).build();

    partOne.getCommodities().setCommodityComplement(
        List.of(CommodityComplement.builder()
            .speciesName(speciesName)
            .speciesID(speciesID)
            .build()));
    partOne.getCommodities().setComplementParameterSet(
        List.of(ComplementParameterSet.builder()
            .speciesID(speciesID)
            .identifiers(List.of(identifier))
            .build())
    );

    assertThat(validator.isValid(partOne, null)).isFalse();
  }

  @Test
  void testThatValidatorReturnsFalse_SpeciesIsCat_Dog_FerretAndPermanentAddressIsNotPlaceOfDestinationAndAddress() {
    Identifier identifier = Identifier.builder().build();

    partOne.getCommodities().setCommodityComplement(
        List.of(CommodityComplement.builder()
            .speciesName("Felis catus")
            .speciesID("3434343")
            .build()));
    partOne.getCommodities().setComplementParameterSet(
        List.of(ComplementParameterSet.builder()
            .speciesID("3434343")
            .identifiers(List.of(identifier))
            .build())
    );

    assertThat(validator.isValid(partOne, null)).isFalse();
  }

  @Test
  void testThatValidatorReturnsTrue_IfCommodityComplementIsEmptyAndPermanentAddressIsNotPlaceOfDestinationIsFalseAndAddressIsNull() {
    Identifier identifier = Identifier.builder()
        .permanentAddress(
            EconomicOperator.builder().build()).build();

    partOne.getCommodities().setCommodityComplement(
        List.of(CommodityComplement.builder()
            .build()));
    partOne.getCommodities().setComplementParameterSet(
        List.of(ComplementParameterSet.builder()
            .speciesID("3434343")
            .identifiers(List.of(identifier))
            .build())
    );

    assertThat(validator.isValid(partOne, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrue_IfParamSetIsEmptyAndPermanentAddressIsNotPlaceOfDestinationIsFalseAndAddressIsNull() {
    partOne.getCommodities().setCommodityComplement(
        List.of(CommodityComplement.builder()
            .speciesName("Felis catus")
            .speciesID("3434343")
            .build()));
    partOne.getCommodities().setComplementParameterSet(
        List.of(ComplementParameterSet.builder()
            .build())
    );

    assertThat(validator.isValid(partOne, null)).isTrue();
  }
}
