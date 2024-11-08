package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.FreeCirculationPurposeEnum;

class InternalMarketValidatorTest {

  private InternalMarketValidator validator;

  @BeforeEach
  void setUp() {
    validator = new InternalMarketValidator();
  }

  @Test
  void givenDecisionIsNull_whenICallIsValid_thenResultIsTrue() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void givenDecisionIsInternalMarketAndFreeCirculationIsNull_whenICallIsValid_thenResultIsFalse() {
    Decision decision = new Decision();
    decision.setDecision(DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET);

    assertThat(validator.isValid(decision, null)).isFalse();
  }

  @Test
  void givenDecisionIsInternalMarketAndFreeCirculationIsNotNull_whenICallIsValid_thenResultIsFalse() {
    Decision decision = new Decision();
    decision.setDecision(DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET);
    decision.setFreeCirculationPurpose(FreeCirculationPurposeEnum.FURTHER_PROCESS);

    assertThat(validator.isValid(decision, null)).isTrue();
  }
}
