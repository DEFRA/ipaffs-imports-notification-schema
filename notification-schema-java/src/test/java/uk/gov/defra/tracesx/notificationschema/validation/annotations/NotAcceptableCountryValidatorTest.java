package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableReasonsEnum;

import java.util.ArrayList;
import java.util.List;

public class NotAcceptableCountryValidatorTest {

  private NotAcceptableCountryValidator validator;

  @Before
  public void setUp() {
    validator = new NotAcceptableCountryValidator();
  }

  @Test
  public void testThatValidatorReturnsTrueIfNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfConsignmentAcceptableReturnsNull() {
    Decision decision = new Decision();

    assertTrue(validator.isValid(decision, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfConsignmentAcceptableIsTrue() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.TRUE);

    assertTrue(validator.isValid(decision, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueIfConsignmentAcceptableIsFalseAndNotAcceptableReasonsIsNull() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);

    assertTrue(validator.isValid(decision, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueIfConsignmentAcceptableIsFalseAndNotAcceptableReasonsIsEmpty() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);
    decision.setNotAcceptableReasons(new ArrayList<>());

    assertTrue(validator.isValid(decision, null));
  }

  @Test
  public void
  testThatValidatorReturnsFalseIfConsignmentAcceptableIsFalseAndNotAcceptableReasonsContainsCountryAndCountryIsNotSelected() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);
    List<NotAcceptableReasonsEnum> reasons = new ArrayList<>();
    reasons.add(NotAcceptableReasonsEnum.NONAPPROVEDCOUNTRY);
    decision.setNotAcceptableReasons(reasons);

    assertFalse(validator.isValid(decision, null));
  }
}
