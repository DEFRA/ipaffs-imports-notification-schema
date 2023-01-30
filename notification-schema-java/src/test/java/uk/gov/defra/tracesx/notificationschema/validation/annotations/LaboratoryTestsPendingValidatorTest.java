package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Conclusion.PENDING;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.LaboratoryTestResult;
import uk.gov.defra.tracesx.notificationschema.representation.LaboratoryTests;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.SingleLaboratoryTest;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.TestReason;

import javax.validation.ConstraintValidatorContext;
import java.util.Collections;

@RunWith(MockitoJUnitRunner.class)
public class LaboratoryTestsPendingValidatorTest {

  private LaboratoryTestsPendingValidator validator;
  private PartTwo partTwo;
  @Mock
  HibernateConstraintValidatorContext hibernateConstraintValidatorContextMock;
  @Mock
  ConstraintValidatorContext constraintValidatorContextMock;
  @Mock
  ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilderMock;
  @Mock
  ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext nodeBuilderContextMock;


  @Before
  public void setUp() {
    partTwo = new PartTwo();
    validator = new LaboratoryTestsPendingValidator();
    when(constraintValidatorContextMock
            .unwrap(HibernateConstraintValidatorContext.class))
            .thenReturn(hibernateConstraintValidatorContextMock);

    when(hibernateConstraintValidatorContextMock
            .buildConstraintViolationWithTemplate(anyString()))
            .thenReturn(constraintViolationBuilderMock);

    when(constraintViolationBuilderMock.addPropertyNode(anyString()))
            .thenReturn(nodeBuilderContextMock);
  }

  @Test
  public void testThatValidatorReturnsTrueIfNullPassed() {
    assertTrue(validator.isValid(null, constraintValidatorContextMock));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIsLaboratoryTestsNotAddedNull() {
    assertTrue(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void testThatValidatorReturnsTrueWhenLaboratoryTestsRequiredIsFalse() {
    partTwo.setLaboratoryTestsRequired(FALSE);

    assertTrue(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void
  testThatValidatorReturnsFalseWhenLaboratoryTestsRequiredIsTrueAndLaboratoryTestsNull() {
    partTwo.setLaboratoryTestsRequired(TRUE);

    assertTrue(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void
  testThatValidatorReturnsTrueWhenLaboratoryTestsRequiredIsTrueAndEmptyLaboratoryTestsList() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    partTwo.setLaboratoryTests(new LaboratoryTests());

    assertTrue(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void testThatValidatorReturnsTrueWhenReasonIsRandom() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.RANDOM);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(new SingleLaboratoryTest()));
    partTwo.setLaboratoryTests(laboratoryTests);

    assertTrue(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void shouldFailValidationWhenReasonIsSuspiciousNoTests() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.SUSPICIOUS);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(new SingleLaboratoryTest()));
    partTwo.setLaboratoryTests(laboratoryTests);

    assertFalse(validator.isValid(partTwo, constraintValidatorContextMock));
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

    assertFalse(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void shouldFailValidationWhenReasonIsReEnforcedNoTests() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.REENFORCED);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(new SingleLaboratoryTest()));
    partTwo.setLaboratoryTests(laboratoryTests);

    assertFalse(validator.isValid(partTwo, constraintValidatorContextMock));
  }

  @Test
  public void shouldFailValidationWhenReasonIsReEnforcedAndOnePendingTest() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.REENFORCED);
    SingleLaboratoryTest singleLaboratoryTest = new SingleLaboratoryTest();
    LaboratoryTestResult laboratoryTestResult = new LaboratoryTestResult();
    laboratoryTestResult.setConclusion(PENDING);
    singleLaboratoryTest.setLaboratoryTestResult(laboratoryTestResult);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(singleLaboratoryTest));
    partTwo.setLaboratoryTests(laboratoryTests);

    assertFalse(validator.isValid(partTwo, constraintValidatorContextMock));
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

    assertTrue(validator.isValid(partTwo, constraintValidatorContextMock));
  }
}
