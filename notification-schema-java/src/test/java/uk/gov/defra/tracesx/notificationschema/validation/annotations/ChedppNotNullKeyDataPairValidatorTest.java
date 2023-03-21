package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.CommodityComplement;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.ComplementParameterSetBuilder;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

@RunWith(MockitoJUnitRunner.class)
public class ChedppNotNullKeyDataPairValidatorTest {

  private static final String FIELD_NAME = "data-field";

  @Mock
  private ChedppNotNullKeyDataPair mockKeyDataPair;

  private ChedppNotNullKeyDataPairValidator validator;

  @Mock
  private Commodities commodities;
  private List<CommodityComplement> commodityComplements = new ArrayList<>();
  private List<ComplementParameterSet> complementParameterSets = new ArrayList<>();

  @Before
  public void setup() {
    validator = new ChedppNotNullKeyDataPairValidator();
    when(mockKeyDataPair.field()).thenReturn(FIELD_NAME);
    when(commodities.getCommodityComplement()).thenReturn(commodityComplements);
    when(commodities.getComplementParameterSet()).thenReturn(complementParameterSets);
    validator.initialize(mockKeyDataPair);
  }

  private CommodityComplement createCommodityComplement(Integer complementID, String speciesID,
      Boolean isWoodPackaging) {
    return CommodityComplement.builder().complementID(complementID).speciesID(speciesID)
        .isWoodPackaging(isWoodPackaging).build();
  }

  private ComplementParameterSet createComplementParameterSet(
      CommodityComplement commodityComplement, ComplementParameterSetKeyDataPair... keyDataPairs) {
    ComplementParameterSetBuilder builder = ComplementParameterSet.builder()
        .complementID(commodityComplement.getComplementID())
        .speciesID(commodityComplement.getSpeciesID());
    if (keyDataPairs != null) {
      builder.keyDataPair(Arrays.asList(keyDataPairs));
    }

    return builder.build();
  }

  @Test
  public void testValidWhenNoCommodityComplement() {
    when(commodities.getCommodityComplement()).thenReturn(null);
    assertTrue(validator.isValid(commodities, null));
  }

  @Test
  public void testValidWhenNoComplementParameterSet() {
    assertTrue(validator.isValid(commodities, null));
  }

  @Test
  public void testValidWhenEmptyCommoditiesData() {
    assertTrue(validator.isValid(commodities, null));
  }

  @Test
  public void testNotValidWhenNoMatchingComplementParameterSet() {
    CommodityComplement commodityComplement = createCommodityComplement(1, "1", null);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
        commodityComplement);
    complementParameterSet.setComplementID(complementParameterSet.getComplementID() + 1);
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void testValidWhenOnlyInvalidWoodPackagingCommodity() {
    CommodityComplement commodityComplement = createCommodityComplement(1, "1", true);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
        commodityComplement);
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertTrue(validator.isValid(commodities, null));
  }

  @Test
  public void testNotValidWhenNullKeyDataPairInComplementParameterSet() {
    CommodityComplement commodityComplement = createCommodityComplement(1, "1", null);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
        commodityComplement);
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void testValidWhenCommodityIsValidAndWoodPackagingIsInvalid() {
    CommodityComplement commodityComplement = createCommodityComplement(1, "1", null);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("hello").build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    commodityComplement = createCommodityComplement(2, "2", true);
    complementParameterSet = createComplementParameterSet(
        commodityComplement);
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertTrue(validator.isValid(commodities, null));
  }

  @Test
  public void testValidWhenAllCommoditiesValid() {
    CommodityComplement commodityComplement = createCommodityComplement(1, "1", null);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("hello").build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    commodityComplement = createCommodityComplement(2, "1", null);
    complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("hello").build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    commodityComplement = createCommodityComplement(3, "1", null);
    complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("hello").build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertTrue(validator.isValid(commodities, null));
  }

  @Test
  public void testNotValidWhenNotAllCommoditiesValid() {
    CommodityComplement commodityComplement = createCommodityComplement(1, "1", null);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("hello").build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    commodityComplement = createCommodityComplement(2, "1", null);
    complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("hello").build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    commodityComplement = createCommodityComplement(3, "1", null);
    complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertFalse(validator.isValid(commodities, null));
  }
}
