package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TRANSHIPMENT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.NON_ACCEPTABLE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.FreeCirculationPurposeEnum.ANIMAL_FEEDING_STUFF;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.FreeCirculationPurposeEnum.FURTHER_PROCESS;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.FreeCirculationPurposeEnum.HUMAN_CONSUMPTION;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.FreeCirculationPurposeEnum.OTHER;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.FreeCirculationPurposeEnum;

@RunWith(Theories.class)
public class FreeCirculationPurposeValidatorTest {

  private FreeCirculationPurposeValidator validator;

  @DataPoints("Other decisions")
  public static final DecisionEnum[] decisions =
      new DecisionEnum[]{
          NON_ACCEPTABLE,
          ACCEPTABLE_FOR_TRANSHIPMENT
      };

  @DataPoints("Free circulation purposes")
  public static final FreeCirculationPurposeEnum[] purpose =
      new FreeCirculationPurposeEnum[]{
          ANIMAL_FEEDING_STUFF,
          HUMAN_CONSUMPTION,
          FURTHER_PROCESS,
          OTHER
      };

  @Before
  public void setUp() {
    validator = new FreeCirculationPurposeValidator();
  }

  @Test
  public void isValid_acceptableForInternalMarketWithoutDecision_isTrue() {
    Decision decision = new Decision();

    boolean result = validator.isValid(decision, null);

    assertTrue(result);
  }

  @Test
  public void isValid_acceptableForInternalMarketWithoutFreeCirculationPurpose_isFalse() {
    Decision decision = Decision.builder().decision(ACCEPTABLE_FOR_INTERNAL_MARKET).build();

    boolean result = validator.isValid(decision, null);

    assertFalse(result);
  }

  @Theory
  public void isValid_acceptableForInternalMarketWithFreeCirculationPurpose_isTrue(
    @FromDataPoints("Free circulation purposes") FreeCirculationPurposeEnum purposeValue) {
    Decision decision = Decision.builder().decision(ACCEPTABLE_FOR_INTERNAL_MARKET)
        .freeCirculationPurpose(purposeValue).build();

    boolean result = validator.isValid(decision, null);

    assertTrue(result);
  }

  @Theory
  public void isValid_otherDecisions_isTrue(
      @FromDataPoints("Other decisions") DecisionEnum decisionValue) {
    Decision decision = Decision.builder().decision(decisionValue).build();

    boolean result = validator.isValid(decision, null);

    assertTrue(result);
  }
}
