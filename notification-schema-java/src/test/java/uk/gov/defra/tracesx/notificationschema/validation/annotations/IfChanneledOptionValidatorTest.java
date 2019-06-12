package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TEMPORARY_IMPORT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TRANSHIPMENT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TRANSIT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.NON_ACCEPTABLE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IfChanneledOptionEnum.ARTICLE8;

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
public class IfChanneledOptionValidatorTest {

  private IfChanneledOptionValidator validator;

  @DataPoints("Other decisions")
  public static DecisionEnum[] decisions =
      new DecisionEnum[]{
          ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE,
          ACCEPTABLE_FOR_INTERNAL_MARKET,
          ACCEPTABLE_FOR_TEMPORARY_IMPORT,
          ACCEPTABLE_FOR_TRANSHIPMENT,
          ACCEPTABLE_FOR_TRANSIT,
          NON_ACCEPTABLE
      };

  @Before
  public void setUp() {
    validator = new IfChanneledOptionValidator();
  }

  @Test
  public void isValid_acceptableIfChanneledWithoutIfChanneledOption_isFalse() {
    Decision decision = Decision.builder().decision(DecisionEnum.ACCEPTABLE_IF_CHANNELED).build();

    boolean result = validator.isValid(decision, null);

    assertFalse(result);
  }

  @Test
  public void isValid_acceptableIfChanneledWithIfChanneledOption_isTrue() {
    Decision decision = Decision.builder().decision(DecisionEnum.ACCEPTABLE_IF_CHANNELED)
        .ifChanneledOption(
            ARTICLE8).build();

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