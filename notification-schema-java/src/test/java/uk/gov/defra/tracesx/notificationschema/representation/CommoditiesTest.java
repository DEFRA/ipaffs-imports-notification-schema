package uk.gov.defra.tracesx.notificationschema.representation;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.LOW_RISK_ARTICLE_72_COMMODITY;

import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;

class CommoditiesTest {

  @Test
  void checkAddCommodityComplementItemWithNullList() {
    Commodities commodities = new Commodities();

    commodities.setCommodityComplement(null);
    commodities
        .addCommodityComplementItem(new CommodityComplement())
        .addCommodityComplementItem(new CommodityComplement());

    assertThat(commodities.getCommodityComplement()).hasSize(2);
  }

  @Test
  void checkAddComplementParameterSetItemWithNullList() {
    Commodities commodities = new Commodities();

    commodities.setComplementParameterSet(null);
    commodities
        .addComplementParameterSetItem(new ComplementParameterSet())
        .addComplementParameterSetItem(new ComplementParameterSet());

    assertThat(commodities.getComplementParameterSet()).hasSize(2);
  }

  @Test
  void isArticle72Consignment_ReturnsFalse_WhenComplementParameterSetIsNull() {
    Commodities commodities = Commodities.builder()
        .isLowRiskArticle72Country(true)
        .build();

    assertThat(commodities.isArticle72Consignment()).isFalse();
  }

  @Test
  void isArticle72Consignment_ReturnsFalse_WhenIsLowRiskArticle72CountryIsNull() {
    Commodities commodities = Commodities.builder()
        .complementParameterSet(List.of(
            buildComplementParameterSet(TRUE),
            buildComplementParameterSet(TRUE)
        )).build();

    assertThat(commodities.isArticle72Consignment()).isFalse();
  }

  @Test
  void isArticle72Consignment_ReturnsFalse_WhenIsLowRiskArticle72CountryIsFalse() {
    Commodities commodities = Commodities.builder()
        .isLowRiskArticle72Country(false)
        .complementParameterSet(List.of(
            buildComplementParameterSet(TRUE),
            buildComplementParameterSet(TRUE)
        )).build();

    assertThat(commodities.isArticle72Consignment()).isFalse();
  }

  @Test
  void isArticle72Consignment_ReturnsFalse_WhenNotAllCommoditiesAreArticle72() {
    Commodities commodities = Commodities.builder()
        .isLowRiskArticle72Country(true)
        .complementParameterSet(List.of(
            buildComplementParameterSet(FALSE),
            buildComplementParameterSet(TRUE)
        )).build();

    assertThat(commodities.isArticle72Consignment()).isFalse();
  }

  @Test
  void isArticle72Consignment_ReturnsTrue_WhenAllCommoditiesAreArticle72() {
    Commodities commodities = Commodities.builder()
        .isLowRiskArticle72Country(true)
        .complementParameterSet(List.of(
            buildComplementParameterSet(TRUE),
            buildComplementParameterSet(TRUE)
        )).build();

    assertThat(commodities.isArticle72Consignment()).isTrue();
  }

  private ComplementParameterSet buildComplementParameterSet(Boolean isLowRiskArticle72Commodity) {
    return ComplementParameterSet.builder()
        .uniqueComplementID(UUID.randomUUID())
        .keyDataPair(List.of(
            ComplementParameterSetKeyDataPair.builder()
                .key(LOW_RISK_ARTICLE_72_COMMODITY)
                .data(isLowRiskArticle72Commodity.toString())
                .build()
        )).build();
  }
}
