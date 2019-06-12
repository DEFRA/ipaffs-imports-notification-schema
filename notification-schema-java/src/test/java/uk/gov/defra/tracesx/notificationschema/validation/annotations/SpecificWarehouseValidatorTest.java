package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TEMPORARY_IMPORT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TRANSHIPMENT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TRANSIT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_IF_CHANNELED;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.NON_ACCEPTABLE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.SpecificWarehouseNonConformingConsignmentEnum.CUSTOMWAREHOUSE;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;

@RunWith(Theories.class)
public class SpecificWarehouseValidatorTest {

  private SpecificWarehouseValidator validator;

  private Decision decision;

  @DataPoints("Other decisions")
  public static DecisionEnum[] decisions =
      new DecisionEnum[]{
          ACCEPTABLE_IF_CHANNELED,
          ACCEPTABLE_FOR_INTERNAL_MARKET,
          ACCEPTABLE_FOR_TEMPORARY_IMPORT,
          ACCEPTABLE_FOR_TRANSHIPMENT,
          ACCEPTABLE_FOR_TRANSIT,
          NON_ACCEPTABLE
      };

  @Before
  public void setUp() {
    this.validator = new SpecificWarehouseValidator();
    this.decision = Decision.builder().build();
  }

  @Test
  public void isValid_DecisionSpecificWarehouseAndEmptySpecificWarehouseNonConformingConsignment_isFalse() {
    decision.setDecision(ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE);

    final boolean result = validator.isValid(decision, null);

    assertFalse(result);
  }

  @Theory
  public void isValid_OtherDecisionsWithoutSpecificWarehouse_isTrue(
      @FromDataPoints("Other decisions") DecisionEnum decisionValue) {
    decision.setDecision(decisionValue);

    final boolean result = validator.isValid(decision, null);

    assertTrue(result);
  }

  @Test
  public void isValid_DecisionSpecificWarehouseAndNotEmptySpecificWarehouseNonConformingConsignment_isTrue() {
    decision.setDecision(ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE);
    decision.setSpecificWarehouseNonConformingConsignment(CUSTOMWAREHOUSE);

    final boolean result = validator.isValid(decision, null);

    assertTrue(result);
  }
}