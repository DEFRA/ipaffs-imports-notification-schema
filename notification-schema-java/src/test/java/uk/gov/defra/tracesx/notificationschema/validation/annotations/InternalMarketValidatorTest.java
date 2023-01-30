package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.FreeCirculationPurposeEnum;

public class InternalMarketValidatorTest {

  private InternalMarketValidator validator;

  @Before
  public void setUp() {
    validator = new InternalMarketValidator();
  }

  @Test
  public void givenDecisionIsNull_whenICallIsValid_thenResultIsTrue() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void givenDecisionIsInternalMarketAndFreeCirculationIsNull_whenICallIsValid_thenResultIsFalse() {
    Decision decision = new Decision();
    decision.setDecision(DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET);

    assertFalse(validator.isValid(decision, null));
  }

  @Test
  public void givenDecisionIsInternalMarketAndFreeCirculationIsNotNull_whenICallIsValid_thenResultIsFalse() {
    Decision decision = new Decision();
    decision.setDecision(DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET);
    decision.setFreeCirculationPurpose(FreeCirculationPurposeEnum.FURTHER_PROCESS);

    assertTrue(validator.isValid(decision, null));
  }
}
