package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableReasonsEnum;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class NotAcceptableReasonValidatorTest {

  private NotAcceptableReasonValidator validator;

  @Before
  public void setUp() {
    validator = new NotAcceptableReasonValidator();
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
  testThatValidatorReturnsFalseIfConsignmentAcceptableIsFalseAndNotAcceptableReasonsIsNull() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);
    assertFalse(validator.isValid(decision, null));
  }

  @Test
  public void
  testThatValidatorReturnsFalseIfConsignmentAcceptableIsFalseAndNotAcceptableReasonsIsEmpty() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);
    decision.setNotAcceptableReasons(new ArrayList<>());
    assertFalse(validator.isValid(decision, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueIfConsignmentAcceptableIsFalseAndNotAcceptableReasonsIsNotEmpty() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);
    List<NotAcceptableReasonsEnum> reasons = new ArrayList<>();
    reasons.add(NotAcceptableReasonsEnum.ABSENCEADDITIONALGUARANTEES);
    decision.setNotAcceptableReasons(reasons);
    assertTrue(validator.isValid(decision, null));
  }
}
