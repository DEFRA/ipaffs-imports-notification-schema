package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.FALSE;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhysicalCheckNotDoneReason.OTHER;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhysicalCheckNotDoneReason.REDUCED_CHECKS_REGIME;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_DONE;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

public class PhysicalCheckReasonNotDoneValidatorTest {

  private PhysicalCheckReasonNotDoneValidator validator;

  @Before
  public void setUp() {
    validator = new PhysicalCheckReasonNotDoneValidator();
  }

  @Test
  public void testThatValidatorReturnsTrueIfNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIsPhysicalCheckDoneReturnsNull() {
    ConsignmentCheck check = new ConsignmentCheck();

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void
  testThatValidatorReturnsFalseIfPhysicalCheckIsNotDoneAndPhysicalCheckNotDoneReasonIsNull() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setPhysicalCheckResult(NOT_DONE);

    assertFalse(validator.isValid(check, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueIfPhysicalCheckIsNotDoneAndPhysicalCheckNotDoneReasonIsReducedChecksRegime() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setPhysicalCheckDone(FALSE);
    check.setPhysicalCheckNotDoneReason(REDUCED_CHECKS_REGIME);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueIfPhysicalCheckIsNotDoneAndPhysicalCheckNotDoneReasonIsOther() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setPhysicalCheckDone(FALSE);
    check.setPhysicalCheckNotDoneReason(OTHER);

    assertTrue(validator.isValid(check, null));
  }
}
