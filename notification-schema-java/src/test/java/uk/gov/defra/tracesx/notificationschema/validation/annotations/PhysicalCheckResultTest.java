package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;

public class PhysicalCheckResultTest {

  private PhysicalCheckResultValidator validator;
  private ConsignmentCheck consignmentCheck;

  @Before
  public void setUp() {
    validator = new PhysicalCheckResultValidator();
    consignmentCheck = new ConsignmentCheck();
  }

  @Test
  public void testThatValidatorReturnsTrueIfNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfPhysicalCheckResultReturnsNull() {
    assertTrue(validator.isValid(new ConsignmentCheck(), null));
  }

  @Test
  public void
  testThatValidatorReturnsFalseIfPhysicalCheckResultReturnsTrueButPhysicalCheckResultReturnsNull() {
    consignmentCheck.setPhysicalCheckDone(true);

    assertFalse(validator.isValid(consignmentCheck, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueIfPhysicalCheckResultReturnsFalseButPhysicalCheckResultReturnsNull() {
    consignmentCheck.setPhysicalCheckDone(false);

    assertTrue(validator.isValid(consignmentCheck, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueIfPhysicalCheckResultReturnsTrueAndPhysicalCheckResultReturnsSatisfactory() {
    consignmentCheck.setPhysicalCheckDone(true);
    consignmentCheck.setPhysicalCheckResult(SATISFACTORY);

    assertTrue(validator.isValid(consignmentCheck, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueIfPhysicalCheckResultReturnsTrueAndPhysicalCheckResultReturnsNotSatisfactory() {
    consignmentCheck.setPhysicalCheckDone(true);
    consignmentCheck.setPhysicalCheckResult(NOT_SATISFACTORY);

    assertTrue(validator.isValid(consignmentCheck, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueIfPhysicalCheckResultReturnsFalseAndPhysicalCheckResultReturnsSatisfactory() {
    consignmentCheck.setPhysicalCheckDone(false);
    consignmentCheck.setPhysicalCheckResult(SATISFACTORY);

    assertTrue(validator.isValid(consignmentCheck, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueIfPhysicalCheckResultReturnsFalseAndPhysicalCheckResultReturnsNotSatisfactory() {
    consignmentCheck.setPhysicalCheckDone(false);
    consignmentCheck.setPhysicalCheckResult(NOT_SATISFACTORY);

    assertTrue(validator.isValid(consignmentCheck, null));
  }
}
