package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.CommodityComplement;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.ComplementParameterSetBuilder;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

@ExtendWith(MockitoExtension.class)
class ChedppMinValueKeyDataPairValidatorTest {

  private static final String FIELD_NAME = "data-field";

  @Mock
  private ChedppMinValueKeyDataPair mockKeyDataPair;

  private ChedppMinValueKeyDataPairValidator validator;

  @Mock
  private Commodities commodities;
  private final List<CommodityComplement> commodityComplements = new ArrayList<>();
  private final List<ComplementParameterSet> complementParameterSets = new ArrayList<>();

  @BeforeEach
  void setup() {
    validator = new ChedppMinValueKeyDataPairValidator();
    when(mockKeyDataPair.field()).thenReturn(FIELD_NAME);
    when(commodities.getCommodityComplement()).thenReturn(commodityComplements);
    validator.initialize(mockKeyDataPair);
  }

  private CommodityComplement createCommodityComplement(Integer complementID, String speciesID,
      Boolean isWoodPackaging) {
    return CommodityComplement.builder().complementID(complementID).speciesID(speciesID)
        .isWoodPackaging(isWoodPackaging).build();
  }

  private ComplementParameterSet createComplementParameterSet(
      CommodityComplement commodityComplement) {
    ComplementParameterSetBuilder builder = ComplementParameterSet.builder()
        .complementID(commodityComplement.getComplementID())
        .speciesID(commodityComplement.getSpeciesID());

    return builder.build();
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
  void testValidWhenNoCommodityComplement() {
    when(commodities.getCommodityComplement()).thenReturn(null);
    assertThat(validator.isValid(commodities, null)).isTrue();
  }

  @Test
  void testValidWhenNoComplementParameterSet() {
    assertThat(validator.isValid(commodities, null)).isTrue();
  }

  @Test
  void testValidWhenEmptyCommoditiesData() {
    assertThat(validator.isValid(commodities, null)).isTrue();
  }

  @Test
  void testNotValidWhenNoMatchingComplementParameterSet() {
    when(commodities.getComplementParameterSet()).thenReturn(complementParameterSets);
    CommodityComplement commodityComplement = createCommodityComplement(1, "1", null);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
        commodityComplement);
    complementParameterSet.setComplementID(complementParameterSet.getComplementID() + 1);
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertThat(validator.isValid(commodities, null)).isFalse();
  }

  @Test
  void testValidWhenOnlyInvalidWoodPackagingCommodity() {
    when(commodities.getComplementParameterSet()).thenReturn(complementParameterSets);
    CommodityComplement commodityComplement = createCommodityComplement(1, "1", true);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
        commodityComplement);
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertThat(validator.isValid(commodities, null)).isTrue();
  }

  @Test
  void testNotValidWhenNullKeyDataPairInComplementParameterSet() {
    CommodityComplement commodityComplement = createCommodityComplement(1, "1", null);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
        commodityComplement);
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertThat(validator.isValid(commodities, null)).isTrue();
  }

  @Test
  void testNullPointerExceptionNotThrownWhenSpeciesIdIsNull() {
    CommodityComplement commodityComplement = createCommodityComplement(1, null, null);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
      commodityComplement,
      ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("10").build(),
      ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertThatCode(() -> validator.isValid(commodities, null)).doesNotThrowAnyException();
  }

  @Test
  void testNullPointerExceptionNotThrownWhenComplementIdIsNull() {
    CommodityComplement commodityComplement = createCommodityComplement(null, "1", null);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
      commodityComplement,
      ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("10").build(),
      ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertThatCode(() -> validator.isValid(commodities, null)).doesNotThrowAnyException();
  }

  @Test
  void testValidWhenCommodityIsValidAndWoodPackagingIsInvalid() {
    CommodityComplement commodityComplement = createCommodityComplement(1, "1", null);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("10").build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    commodityComplement = createCommodityComplement(2, "2", true);
    complementParameterSet = createComplementParameterSet(
        commodityComplement);
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertThat(validator.isValid(commodities, null)).isTrue();
  }

  @Test
  void testValidWhenAllCommoditiesValid() {
    CommodityComplement commodityComplement = createCommodityComplement(1, "1", null);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("1").build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    commodityComplement = createCommodityComplement(2, "1", null);
    complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("1.0").build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    commodityComplement = createCommodityComplement(3, "1", null);
    complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("1.11").build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertThat(validator.isValid(commodities, null)).isTrue();
  }

  @Test
  void testNotValidWhenNotAllCommoditiesValid() {
    when(commodities.getComplementParameterSet()).thenReturn(complementParameterSets);
    CommodityComplement commodityComplement = createCommodityComplement(1, "1", null);
    ComplementParameterSet complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("1").build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    commodityComplement = createCommodityComplement(2, "1", null);
    complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("x").build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    commodityComplement = createCommodityComplement(3, "1", null);
    complementParameterSet = createComplementParameterSet(
        commodityComplement,
        ComplementParameterSetKeyDataPair.builder().key(FIELD_NAME).data("1").build(),
        ComplementParameterSetKeyDataPair.builder().key("foo").data("bar").build());
    commodityComplements.add(commodityComplement);
    complementParameterSets.add(complementParameterSet);

    assertThat(validator.isValid(commodities, null)).isFalse();
  }
}
