package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentificationCheckType.FULL_IDENTITY_CHECK;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentificationCheckType.SEAL_CHECK;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;

public class IdentityCheckTypeValidatorTest {

  private ConsignmentCheck check;
  private IdentityCheckTypeValidator validator;

  @Before
  public void setUp() {
    validator = new IdentityCheckTypeValidator();
    check = new ConsignmentCheck();
  }

  @Test
  public void testThatValidatorReturnsTrueIfNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIdentityCheckResultIsNotSatisfactory() {
    check.setIdentityCheckResult(NOT_SATISFACTORY);
    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIdentityCheckResultIsSatisfactoryAndTypeIsSealCheck() {
    check.setIdentityCheckResult(SATISFACTORY);
    check.setIdentityCheckType(SEAL_CHECK);
    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueIfIdentityCheckResultIsSatisfactoryAndTypeIsFullIdentityCheck() {
    check.setIdentityCheckResult(SATISFACTORY);
    check.setIdentityCheckType(FULL_IDENTITY_CHECK);
    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void testThatValidatorReturnsFalseIfIdentityCheckResultIsSatisfactoryButTypeIsNull() {
    check.setIdentityCheckResult(SATISFACTORY);
    assertFalse(validator.isValid(check, null));
  }
}
