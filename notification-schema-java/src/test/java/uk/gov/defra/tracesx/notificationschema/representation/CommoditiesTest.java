package uk.gov.defra.tracesx.notificationschema.representation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CommoditiesTest {

  @Test
  public void checkAddCommodityComplementItemWithNullList() {

    Commodities commodities = new Commodities();

    commodities.setCommodityComplement(null);
    commodities
        .addCommodityComplementItem(new CommodityComplement())
        .addCommodityComplementItem(new CommodityComplement());

    assertEquals(commodities.getCommodityComplement().size(), 2);
  }

  @Test
  public void checkAddComplementParameterSetItemWithNullList() {

    Commodities commodities = new Commodities();

    commodities.setComplementParameterSet(null);
    commodities
        .addComplementParameterSetItem(new ComplementParameterSet())
        .addComplementParameterSetItem(new ComplementParameterSet());

    assertEquals(commodities.getComplementParameterSet().size(), 2);
  }
}
