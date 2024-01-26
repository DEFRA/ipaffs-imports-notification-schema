package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintViolationBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;

import jakarta.validation.ConstraintValidatorContext;

@RunWith(MockitoJUnitRunner.class)
public class ChedaPurposeExitDateNotNullValidatorTest {

  private ChedaPurposeExitDateNotNullValidator validator;
  private Purpose purpose;

  @Mock
  HibernateConstraintValidatorContext hibernateConstraintValidatorContextMock;
  @Mock
  ConstraintValidatorContext constraintValidatorContextMock;
  @Mock
  HibernateConstraintViolationBuilder hibernateConstraintViolationBuilder;
  @Mock
  ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext nodeBuilderContextMock;

  @Before
  public void setup() {
    validator = new ChedaPurposeExitDateNotNullValidator();
    purpose = new Purpose();
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
  public void validatorShouldReturnFalseIfPurposeIsNull() {
    // Given / When
    boolean result = validator.isValid(null, constraintValidatorContextMock);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnTrueIfForImportOrAdmissionIsNotTemporaryAdmissionHorses() {
    // Given
    purpose.setForImportOrAdmission(ForImportOrAdmissionEnum.DEFINITIVE_IMPORT);

    // When
    boolean result = validator.isValid(purpose, null);

    // Then
    assertTrue(result);
  }


  @Test
  public void validatorShouldReturnTrueIfForImportOrAdmissionIsTemporaryAdmissionHorsesWithExitDate() {
    // Given
    purpose.setForImportOrAdmission(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES);
    purpose.setExitDate("exit date");

    // When
    boolean result = validator.isValid(purpose, null);

    // Then
    assertTrue(result);
  }

  @Test
  public void validatorShouldReturnFalseIfForImportOrAdmissionIsTemporaryAdmissionHorsesWithNoExitDate() {
    // Given
    purpose.setForImportOrAdmission(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES);

    // When
    boolean result = validator.isValid(purpose, constraintValidatorContextMock);

    // Then
    assertFalse(result);
  }
}
