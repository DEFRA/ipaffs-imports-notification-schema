package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_DONE;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

public class IdentityCheckValidatorTest {

  private ConsignmentCheck check;
  private IdentityCheckResultValidator validator;

  @Before
  public void setUp() {
    validator = new IdentityCheckResultValidator();
    check = new ConsignmentCheck();
  }

  @Test
  public void testThatValidatorReturnsTrueIfNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIdentityCheckDoneIsFalse() {
    check.setIdentityCheckDone(false);
    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIdentityCheckDoneIsTrueAndResultIsSatisfactory() {
    check.setIdentityCheckDone(true);
    check.setIdentityCheckResult(SATISFACTORY);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIdentityCheckDoneIsTrueAndResultIsNotSatisfactory() {
    check.setIdentityCheckDone(true);
    check.setIdentityCheckResult(NOT_SATISFACTORY);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void testThatValidatorReturnsFalseIfIdentityCheckDoneIsTrueAndResultIsNull() {
    check.setIdentityCheckDone(true);

    assertFalse(validator.isValid(check, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIdentityCheckDoneIsFalseAndResultIsNotDone() {
    check.setIdentityCheckDone(false);
    check.setIdentityCheckResult(NOT_DONE);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIdentityCheckDoneIsTrueAndResultIsNotDone() {
    check.setIdentityCheckDone(true);
    check.setIdentityCheckResult(NOT_DONE);

    assertTrue(validator.isValid(check, null));
  }
}
