package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.CommodityComplement;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class NotNullWoodPackagingCommodityValidatorTest {

  private PartOne partOne;
  private NotNullWoodPackagingCommodityValidator validator;

  @Before
  public void setUp() {
    partOne = new PartOne();
    validator = new NotNullWoodPackagingCommodityValidator();
  }

  @Test
  public void validatorReturnsTrue_ifNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void validatorReturnsTrue_ifCommoditiesIsNull() {
    assertTrue(validator.isValid(partOne, null));
  }

  @Test
  public void validatorReturnsTrue_ifCommodityComplementIsNull() {
    partOne.setCommodities(new Commodities());

    assertTrue(validator.isValid(partOne, null));
  }

  @Test
  public void validatorReturnsTrue_ifContainsWoodPackagingIsNull() {
    partOne.setCommodities(Commodities.builder().commodityComplement(new ArrayList<>()).build());

    assertTrue(validator.isValid(partOne, null));
  }

  @Test
  public void validatorReturnsTrue_ifContainsWoodPackagingIsFalse() {
    partOne.setCommodities(Commodities.builder().commodityComplement(new ArrayList<>()).build());
    partOne.setContainsWoodPackaging(false);

    assertTrue(validator.isValid(partOne, null));
  }

  @Test
  public void validatorReturnsFalse_ifNoCommodities() {
    partOne.setCommodities(Commodities.builder().commodityComplement(new ArrayList<>()).build());
    partOne.setContainsWoodPackaging(true);

    assertFalse(validator.isValid(partOne, null));
  }

  @Test
  public void validatorReturnsFalse_ifNoWoodPackagingCommodities() {
    partOne.setCommodities(
        Commodities.builder()
            .commodityComplement(new ArrayList<>() {{
              add(new CommodityComplement());
              add(CommodityComplement.builder().isWoodPackaging(false).build());
            }})
            .build());
    partOne.setContainsWoodPackaging(true);

    assertFalse(validator.isValid(partOne, null));
  }

  @Test
  public void validatorReturnsTrue_ifWoodPackagingCommodities() {
    partOne.setCommodities(
        Commodities.builder()
            .commodityComplement(new ArrayList<>() {{
              add(new CommodityComplement());
              add(CommodityComplement.builder().isWoodPackaging(false).build());
              add(CommodityComplement.builder().isWoodPackaging(true).build());
            }})
            .build());
    partOne.setContainsWoodPackaging(true);

    assertTrue(validator.isValid(partOne, null));
  }
}
