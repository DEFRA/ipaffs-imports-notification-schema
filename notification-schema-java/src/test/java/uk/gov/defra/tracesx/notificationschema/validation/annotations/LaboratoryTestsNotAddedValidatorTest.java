package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.LaboratoryTests;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.SingleLaboratoryTest;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class LaboratoryTestsNotAddedValidatorTest {

  private LaboratoryTestsNotAddedValidator validator;

  @Before
  public void setUp() {
    validator = new LaboratoryTestsNotAddedValidator();
  }

  @Test
  public void testThatValidatorReturnsTrueIfNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIsLaboratoryTestsNotAddedNull() {
    PartTwo partTwo = new PartTwo();
    assertTrue(validator.isValid(partTwo, null));
  }

  @Test
  public void testThatValidatorReturnsTrueWhenLaboratoryTestsRequiredIsFalse() {
    PartTwo partTwo = new PartTwo();
    partTwo.setLaboratoryTestsRequired(FALSE);
    assertTrue(validator.isValid(partTwo, null));
  }

  @Test
  public void
  testThatValidatorReturnsFalseWhenLaboratoryTestsRequiredIsTrueAndLaboratoryTestsNull() {
    PartTwo partTwo = new PartTwo();
    partTwo.setLaboratoryTestsRequired(TRUE);
    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void
  testThatValidatorReturnsFalseWhenLaboratoryTestsRequiredIsTrueAndEmptyLaboratoryTestsList() {
    PartTwo partTwo = new PartTwo();
    partTwo.setLaboratoryTestsRequired(TRUE);
    partTwo.setLaboratoryTests(new LaboratoryTests());
    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void
  testThatValidatorReturnsTrueWhenLaboratoryTestsRequiredIsTrueAndLaboratoryTestsListWithOneTest() {
    PartTwo partTwo = new PartTwo();
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setSingleLaboratoryTests(Arrays.asList(new SingleLaboratoryTest()));
    partTwo.setLaboratoryTests(laboratoryTests);
    assertTrue(validator.isValid(partTwo, null));
  }
}
