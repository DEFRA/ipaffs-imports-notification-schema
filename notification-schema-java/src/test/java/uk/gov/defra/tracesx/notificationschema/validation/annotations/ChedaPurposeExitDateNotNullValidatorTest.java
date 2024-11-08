package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintViolationBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;

import jakarta.validation.ConstraintValidatorContext;

@ExtendWith(MockitoExtension.class)
class ChedaPurposeExitDateNotNullValidatorTest {

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

  @BeforeEach
  void setup() {
    validator = new ChedaPurposeExitDateNotNullValidator();
    purpose = new Purpose();

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
  void validatorShouldReturnFalseIfPurposeIsNull() {
    validatorMocking();
    // Given / When
    boolean result = validator.isValid(null, constraintValidatorContextMock);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnTrueIfForImportOrAdmissionIsNotTemporaryAdmissionHorses() {
    // Given
    purpose.setForImportOrAdmission(ForImportOrAdmissionEnum.DEFINITIVE_IMPORT);

    // When
    boolean result = validator.isValid(purpose, null);

    // Then
    assertThat(result).isTrue();
  }


  @Test
  void validatorShouldReturnTrueIfForImportOrAdmissionIsTemporaryAdmissionHorsesWithExitDate() {
    // Given
    purpose.setForImportOrAdmission(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES);
    purpose.setExitDate("exit date");

    // When
    boolean result = validator.isValid(purpose, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnFalseIfForImportOrAdmissionIsTemporaryAdmissionHorsesWithNoExitDate() {
    // Given
    purpose.setForImportOrAdmission(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES);
    validatorMocking();

    // When
    boolean result = validator.isValid(purpose, constraintValidatorContextMock);

    // Then
    assertThat(result).isFalse();
  }
}
