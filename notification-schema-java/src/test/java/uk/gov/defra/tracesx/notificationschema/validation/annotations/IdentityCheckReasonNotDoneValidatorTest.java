package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.FALSE;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentityCheckNotDoneReason.NOT_REQUIRED;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentityCheckNotDoneReason.REDUCED_CHECKS_REGIME;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_DONE;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

public class IdentityCheckReasonNotDoneValidatorTest {

  private IdentityCheckReasonNotDoneValidator validator;

  @Before
  public void setUp() {
    validator = new IdentityCheckReasonNotDoneValidator();
  }

  @Test
  public void testThatValidatorReturnsTrueIfNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIsIdentityCheckDoneReturnsNull() {
    ConsignmentCheck check = new ConsignmentCheck();

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void testThatValidatorReturnsFalseIfIdentityCheckIsNotDoneAndIdentityCheckNotDoneReasonIsNull() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setIdentityCheckResult(NOT_DONE);

    assertFalse(validator.isValid(check, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIdentityCheckIsNotDoneAndIdentityCheckNotDoneReasonIsReducedChecksRegime() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setIdentityCheckDone(FALSE);
    check.setIdentityCheckResult(NOT_DONE);
    check.setIdentityCheckNotDoneReason(REDUCED_CHECKS_REGIME);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIdentityCheckIsNotDoneAndIdentityCheckNotDoneReasonIsNotRequired() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setIdentityCheckDone(FALSE);
    check.setIdentityCheckResult(NOT_DONE);
    check.setIdentityCheckNotDoneReason(NOT_REQUIRED);

    assertTrue(validator.isValid(check, null));
  }
}
