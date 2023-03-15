package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;

public class MinCommodityGrossWeightValidatorTest {

  private Commodities commodities;
  private MinCommoditiesGrossWeightValidator validator;

  @Before
  public void setUp() {
    commodities = new Commodities();
    validator = new MinCommoditiesGrossWeightValidator();
  }

  @Test
  public void validatorReturnsTrueIfNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void validatorReturnsTrueIfGrossWeightHigherThanNetWeight() {
    commodities.setTotalNetWeight(new BigDecimal("10"));
    commodities.setTotalGrossWeight(new BigDecimal("15"));

    assertTrue(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsFalseIfGrossWeightLowerThanNetWeight() {
    commodities.setTotalNetWeight(new BigDecimal("15"));
    commodities.setTotalGrossWeight(new BigDecimal("10"));

    assertFalse(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsTrueIfTotalNetWeightIsNull() {
    commodities.setTotalGrossWeight(new BigDecimal("10"));

    assertTrue(validator.isValid(commodities, null));
  }

  @Test
  public void validatorReturnsTrueIfTotalGrossWeightIsNull() {
    commodities.setTotalNetWeight(new BigDecimal("10"));

    assertTrue(validator.isValid(commodities, null));
  }
}
