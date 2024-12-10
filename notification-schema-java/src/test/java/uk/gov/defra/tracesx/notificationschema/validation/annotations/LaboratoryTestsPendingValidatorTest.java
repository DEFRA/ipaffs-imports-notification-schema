package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Conclusion.PENDING;

import java.util.Collections;
import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintViolationBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.LaboratoryTestResult;
import uk.gov.defra.tracesx.notificationschema.representation.LaboratoryTests;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.SingleLaboratoryTest;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.TestReason;

@ExtendWith(MockitoExtension.class)
class LaboratoryTestsPendingValidatorTest {

  private LaboratoryTestsPendingValidator validator;
  private PartTwo partTwo;
  @Mock
  HibernateConstraintValidatorContext hibernateConstraintValidatorContextMock;
  @Mock
  ConstraintValidatorContext constraintValidatorContextMock;
  @Mock
  HibernateConstraintViolationBuilder hibernateConstraintViolationBuilder;
  @Mock
  ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext nodeBuilderContextMock;


  @BeforeEach
  void setUp() {
    partTwo = new PartTwo();
    validator = new LaboratoryTestsPendingValidator();
  }

  void validatorMocking() {
    when(constraintValidatorContextMock
        .unwrap(HibernateConstraintValidatorContext.class))
        .thenReturn(hibernateConstraintValidatorContextMock);

    when(hibernateConstraintValidatorContextMock
        .buildConstraintViolationWithTemplate(anyString()))
        .thenReturn(hibernateConstraintViolationBuilder);

    when(hibernateConstraintViolationBuilder.addPropertyNode(anyString()))
        .thenReturn(nodeBuilderContextMock);
  }

  @Test
  void testThatValidatorReturnsTrueIfNullPassed() {
    assertThat(validator.isValid(null, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueIfIsLaboratoryTestsNotAddedNull() {
    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueWhenLaboratoryTestsRequiredIsFalse() {
    partTwo.setLaboratoryTestsRequired(FALSE);

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void
  testThatValidatorReturnsFalseWhenLaboratoryTestsRequiredIsTrueAndLaboratoryTestsNull() {
    partTwo.setLaboratoryTestsRequired(TRUE);

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void
  testThatValidatorReturnsTrueWhenLaboratoryTestsRequiredIsTrueAndEmptyLaboratoryTestsList() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    partTwo.setLaboratoryTests(new LaboratoryTests());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueWhenReasonIsRandom() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.RANDOM);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(new SingleLaboratoryTest()));
    partTwo.setLaboratoryTests(laboratoryTests);

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void shouldFailValidationWhenReasonIsSuspiciousNoTests() {
    validatorMocking();
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.SUSPICIOUS);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(new SingleLaboratoryTest()));
    partTwo.setLaboratoryTests(laboratoryTests);

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void shouldFailValidationWhenReasonIsSuspiciousAndOnePendingTest() {
    validatorMocking();
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.SUSPICIOUS);
    SingleLaboratoryTest singleLaboratoryTest = new SingleLaboratoryTest();
    LaboratoryTestResult laboratoryTestResult = new LaboratoryTestResult();
    laboratoryTestResult.setConclusion(PENDING);
    singleLaboratoryTest.setLaboratoryTestResult(laboratoryTestResult);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(singleLaboratoryTest));
    partTwo.setLaboratoryTests(laboratoryTests);

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void shouldFailValidationWhenReasonIsReEnforcedNoTests() {
    validatorMocking();
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.REENFORCED);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(new SingleLaboratoryTest()));
    partTwo.setLaboratoryTests(laboratoryTests);

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void shouldFailValidationWhenReasonIsReEnforcedAndOnePendingTest() {
    validatorMocking();
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.REENFORCED);
    SingleLaboratoryTest singleLaboratoryTest = new SingleLaboratoryTest();
    LaboratoryTestResult laboratoryTestResult = new LaboratoryTestResult();
    laboratoryTestResult.setConclusion(PENDING);
    singleLaboratoryTest.setLaboratoryTestResult(laboratoryTestResult);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(singleLaboratoryTest));
    partTwo.setLaboratoryTests(laboratoryTests);

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void testThatValidatorReturnsTrueWhenReasonIsRandomAndOnePendingTest() {
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setTestReason(TestReason.RANDOM);
    SingleLaboratoryTest singleLaboratoryTest = new SingleLaboratoryTest();
    LaboratoryTestResult laboratoryTestResult = new LaboratoryTestResult();
    laboratoryTestResult.setConclusion(PENDING);
    singleLaboratoryTest.setLaboratoryTestResult(laboratoryTestResult);
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(singleLaboratoryTest));
    partTwo.setLaboratoryTests(laboratoryTests);

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }
}
