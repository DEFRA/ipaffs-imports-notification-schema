package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.SpecificWarehouseNonConformingConsignmentEnum.CUSTOMWAREHOUSE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;

class SpecificWarehouseValidatorTest {

  private SpecificWarehouseValidator validator;

  private Decision decision;

  @BeforeEach
  void setUp() {
    this.validator = new SpecificWarehouseValidator();
    this.decision = Decision.builder().build();
  }

  @Test
  void isValid_DecisionSpecificWarehouseAndEmptySpecificWarehouseNonConformingConsignment_isFalse() {
    decision.setDecision(ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE);

    final boolean result = validator.isValid(decision, null);

    assertThat(result).isFalse();
  }

  @ParameterizedTest
  @EnumSource(value = DecisionEnum.class, names = {"ACCEPTABLE_IF_CHANNELED",
      "ACCEPTABLE_FOR_INTERNAL_MARKET", "ACCEPTABLE_FOR_TEMPORARY_IMPORT",
      "ACCEPTABLE_FOR_TRANSHIPMENT", "ACCEPTABLE_FOR_TRANSIT", "NON_ACCEPTABLE"})
  void isValid_OtherDecisionsWithoutSpecificWarehouse_isTrue(DecisionEnum decisionValue) {
    decision.setDecision(decisionValue);

    final boolean result = validator.isValid(decision, null);

    assertThat(result).isTrue();
  }

  @Test
  void isValid_DecisionSpecificWarehouseAndNotEmptySpecificWarehouseNonConformingConsignment_isTrue() {
    decision.setDecision(ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE);
    decision.setSpecificWarehouseNonConformingConsignment(CUSTOMWAREHOUSE);

    final boolean result = validator.isValid(decision, null);

    assertThat(result).isTrue();
  }
}
