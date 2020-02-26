package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.CommodityComplement;
import uk.gov.defra.tracesx.notificationschema.representation.EconomicOperator;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

import java.util.Collections;

public class DogPlaceOfOriginImpValidatorTest {

  private static final String DOG_SPECIES_NAME = "Canis familiaris";

  private PartOne partOne;
  private DogPlaceOfOriginImpValidator validator;

  @Before
  public void setUp() {
    validator = new DogPlaceOfOriginImpValidator();
    partOne = new PartOne();
  }

  @Test
  public void testThatValidatorReturnsTrue_IfNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testThatValidatorReturnsTrue_IfCommodities_Null() {
    assertTrue(validator.isValid(partOne, null));
  }

  @Test
  public void testThatValidatorReturnsTrue_IfCommodityComplement_IsNull() {
    partOne.setCommodities(new Commodities());
    assertTrue(validator.isValid(partOne, null));
  }

  @Test
  public void testThatValidatorReturnsTrue_IfCommodityComplements_SpeciesNameNull() {
    partOne.setCommodities(Commodities.builder()
        .commodityComplement(Collections.singletonList(CommodityComplement.builder()
            .speciesName(null)
            .build()))
        .build());
    assertTrue(validator.isValid(partOne, null));
  }

  @Test
  public void testThatValidatorReturnsTrue_IfCommodityComplements_DoesNotContainDogCommodity() {
    partOne.setCommodities(Commodities.builder()
        .commodityComplement(Collections.singletonList(CommodityComplement.builder()
            .speciesName("notDog")
            .build()))
        .build());
    assertTrue(validator.isValid(partOne, null));
  }

  @Test
  public void testThatValidatorReturnsTrue_IfCommodityComplements_ContainsDogCommodity_AndPlaceOfOriginNotNull() {
    partOne.setCommodities(Commodities.builder()
        .commodityComplement(Collections.singletonList(CommodityComplement.builder()
            .speciesName(DOG_SPECIES_NAME)
            .build()))
        .build());
    partOne.setConsignor(new EconomicOperator());
    assertTrue(validator.isValid(partOne, null));
  }

  @Test
  public void testThatValidatorReturnsFalse_IfCommodityComplements_ContainsDogCommodity_AndPlaceOfOriginNull() {
    partOne.setCommodities(Commodities.builder()
        .commodityComplement(Collections.singletonList(CommodityComplement.builder()
            .speciesName(DOG_SPECIES_NAME)
            .build()))
        .build());
    assertFalse(validator.isValid(partOne, null));
  }
}
