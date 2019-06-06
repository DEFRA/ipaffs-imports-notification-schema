package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.SLAUGHTER;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;

public class NotAcceptableActionValidatorTest {

  private NotAcceptableActionValidator validator;

  @Before
  public void setUp() {
    validator = new NotAcceptableActionValidator();
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
    decision.setConsignmentAcceptable(TRUE);
    assertTrue(validator.isValid(decision, null));
  }

  @Test
  public void
  testThatValidatorReturnsFalseIfConsignmentAcceptableIsFalseAndNotAcceptableActionIsNull() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(FALSE);
    assertFalse(validator.isValid(decision, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueIfConsignmentAcceptableIsFalseAndNNotAcceptableActionIsNotDone() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(FALSE);
    decision.setNotAcceptableAction(SLAUGHTER);
    assertTrue(validator.isValid(decision, null));
  }
}
