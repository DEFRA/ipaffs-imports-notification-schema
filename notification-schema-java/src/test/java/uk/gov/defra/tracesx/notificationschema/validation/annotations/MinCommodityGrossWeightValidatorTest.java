package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;

class MinCommodityGrossWeightValidatorTest {

  private Commodities commodities;
  private MinCommoditiesGrossWeightValidator validator;

  @BeforeEach
  void setUp() {
    commodities = new Commodities();
    validator = new MinCommoditiesGrossWeightValidator();
  }

  @Test
  void validatorReturnsTrueIfNullPassed() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void validatorReturnsTrueIfGrossWeightHigherThanNetWeight() {
    commodities.setTotalNetWeight(new BigDecimal("10"));
    commodities.setTotalGrossWeight(new BigDecimal("15"));

    assertThat(validator.isValid(commodities, null)).isTrue();
  }

  @Test
  void validatorReturnsFalseIfGrossWeightLowerThanNetWeight() {
    commodities.setTotalNetWeight(new BigDecimal("15"));
    commodities.setTotalGrossWeight(new BigDecimal("10"));

    assertThat(validator.isValid(commodities, null)).isFalse();
  }

  @Test
  void validatorReturnsTrueIfTotalNetWeightIsNull() {
    commodities.setTotalGrossWeight(new BigDecimal("10"));

    assertThat(validator.isValid(commodities, null)).isTrue();
  }

  @Test
  void validatorReturnsTrueIfTotalGrossWeightIsNull() {
    commodities.setTotalNetWeight(new BigDecimal("10"));

    assertThat(validator.isValid(commodities, null)).isTrue();
  }
}
