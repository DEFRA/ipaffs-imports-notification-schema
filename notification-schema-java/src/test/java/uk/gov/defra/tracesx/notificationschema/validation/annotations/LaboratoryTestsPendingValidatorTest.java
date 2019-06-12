package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Conclusion.PENDING;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.LaboratoryTestResult;
import uk.gov.defra.tracesx.notificationschema.representation.LaboratoryTests;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.SingleLaboratoryTest;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.TestReason;

import java.util.Collections;

public class LaboratoryTestsPendingValidatorTest {

  private LaboratoryTestsPendingValidator validator;
  private PartTwo partTwo;

  @Before
  public void setUp() {
    partTwo = new PartTwo();
    validator = new LaboratoryTestsPendingValidator();
  }

  @Test
  public void testThatValidatorReturnsTrueIfNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIsLaboratoryTestsNotAddedNull() {
    assertTrue(validator.isValid(partTwo, null));
  }

  @Test
  public void testThatValidatorReturnsTrueWhenLaboratoryTestsRequiredIsFalse() {
    partTwo.setLaboratoryTestsRequired(FALSE);
    assertTrue(validator.isValid(partTwo, null));
  }

  @Test
  public void
  testThatValidatorReturnsFalseWhenLaboratoryTestsRequiredIsTrueAndLaboratoryTestsNull() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    assertTrue(validator.isValid(partTwo, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueWhenLaboratoryTestsRequiredIsTrueAndEmptyLaboratoryTestsList() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    partTwo.setLaboratoryTests(new LaboratoryTests());
    assertTrue(validator.isValid(partTwo, null));
  }

  @Test
  public void testThatValidatorReturnsTrueWhenReasonIsRandom() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.RANDOM);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(new SingleLaboratoryTest()));
    partTwo.setLaboratoryTests(laboratoryTests);
    assertTrue(validator.isValid(partTwo, null));
  }

  @Test
  public void shouldFailValidationWhenReasonIsSuspiciousNoTests() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.SUSPICIOUS);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(new SingleLaboratoryTest()));
    partTwo.setLaboratoryTests(laboratoryTests);
    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void shouldFailValidationWhenReasonIsSuspiciousAndOnePendingTest() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.SUSPICIOUS);
    SingleLaboratoryTest singleLaboratoryTest = new SingleLaboratoryTest();
    LaboratoryTestResult laboratoryTestResult = new LaboratoryTestResult();
    laboratoryTestResult.setConclusion(PENDING);
    singleLaboratoryTest.setLaboratoryTestResult(laboratoryTestResult);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(singleLaboratoryTest));
    partTwo.setLaboratoryTests(laboratoryTests);
    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void testThatValidatorReturnsTrueWhenReasonIsRandomAndOnePendingTest() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.RANDOM);
    SingleLaboratoryTest singleLaboratoryTest = new SingleLaboratoryTest();
    LaboratoryTestResult laboratoryTestResult = new LaboratoryTestResult();
    laboratoryTestResult.setConclusion(PENDING);
    singleLaboratoryTest.setLaboratoryTestResult(laboratoryTestResult);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(singleLaboratoryTest));
    partTwo.setLaboratoryTests(laboratoryTests);
    assertTrue(validator.isValid(partTwo, null));
  }
}
