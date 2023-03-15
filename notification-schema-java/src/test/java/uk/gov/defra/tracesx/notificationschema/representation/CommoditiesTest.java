package uk.gov.defra.tracesx.notificationschema.representation;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet.LOW_RISK_ARTICLE_72_COMMODITY;

import java.util.List;
import java.util.UUID;
import org.junit.Test;

public class CommoditiesTest {

  @Test
  public void checkAddCommodityComplementItemWithNullList() {
    Commodities commodities = new Commodities();

    commodities.setCommodityComplement(null);
    commodities
        .addCommodityComplementItem(new CommodityComplement())
        .addCommodityComplementItem(new CommodityComplement());

    assertEquals(2, commodities.getCommodityComplement().size());
  }

  @Test
  public void checkAddComplementParameterSetItemWithNullList() {
    Commodities commodities = new Commodities();

    commodities.setComplementParameterSet(null);
    commodities
        .addComplementParameterSetItem(new ComplementParameterSet())
        .addComplementParameterSetItem(new ComplementParameterSet());

    assertEquals(2, commodities.getComplementParameterSet().size());
  }

  @Test
  public void isArticle72Consignment_ReturnsFalse_WhenComplementParameterSetIsNull() {
    Commodities commodities = Commodities.builder()
        .isLowRiskArticle72Country(true)
        .build();

    assertFalse(commodities.isArticle72Consignment());
  }

  @Test
  public void isArticle72Consignment_ReturnsFalse_WhenIsLowRiskArticle72CountryIsNull() {
    Commodities commodities = Commodities.builder()
        .complementParameterSet(List.of(
            buildComplementParameterSet(TRUE),
            buildComplementParameterSet(TRUE)
        )).build();

    assertFalse(commodities.isArticle72Consignment());
  }

  @Test
  public void isArticle72Consignment_ReturnsFalse_WhenIsLowRiskArticle72CountryIsFalse() {
    Commodities commodities = Commodities.builder()
        .isLowRiskArticle72Country(false)
        .complementParameterSet(List.of(
            buildComplementParameterSet(TRUE),
            buildComplementParameterSet(TRUE)
        )).build();

    assertFalse(commodities.isArticle72Consignment());
  }

  @Test
  public void isArticle72Consignment_ReturnsFalse_WhenNotAllCommoditiesAreArticle72() {
    Commodities commodities = Commodities.builder()
        .isLowRiskArticle72Country(true)
        .complementParameterSet(List.of(
            buildComplementParameterSet(FALSE),
            buildComplementParameterSet(TRUE)
        )).build();

    assertFalse(commodities.isArticle72Consignment());
  }

  @Test
  public void isArticle72Consignment_ReturnsTrue_WhenAllCommoditiesAreArticle72() {
    Commodities commodities = Commodities.builder()
        .isLowRiskArticle72Country(true)
        .complementParameterSet(List.of(
            buildComplementParameterSet(TRUE),
            buildComplementParameterSet(TRUE)
        )).build();

    assertTrue(commodities.isArticle72Consignment());
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
