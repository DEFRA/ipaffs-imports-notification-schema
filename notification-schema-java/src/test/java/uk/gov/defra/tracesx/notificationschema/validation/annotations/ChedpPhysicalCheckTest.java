package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;

import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintViolationBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;

@ExtendWith(MockitoExtension.class)
class ChedpPhysicalCheckTest {

  private ChedpPhysicalCheckValidator validator;
  private PartTwo partTwo;

  @Mock
  HibernateConstraintValidatorContext hibernateConstraintValidatorContextMock;
  @Mock
  ConstraintValidatorContext constraintValidatorContextMock;
  @Mock
  HibernateConstraintViolationBuilder hibernateConstraintViolationBuilder;
  @Mock
  NodeBuilderCustomizableContext nodeBuilderContextMock;

  @BeforeEach
  void setUp() {
    validator = new ChedpPhysicalCheckValidator();
    partTwo = new PartTwo();
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
  void isValid_returnsFalse_whenPartTwoNull() {
    validatorMocking();
    assertThat(validator.isValid(null, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_returnsFalse_whenConsignmentCheckNull() {
    validatorMocking();
    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }


  @Test
  void isValid_returnsFalse_whenDocumentCheckNullAndPhysicalCheckResultNull() {
    validatorMocking();
    partTwo.setConsignmentCheck(new ConsignmentCheck());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckNullAndPhysicalCheckResultNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .physicalCheckResult(NOT_SATISFACTORY)
        .build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }


  @Test
  void isValid_returnsFalse_whenDocumentCheckSatisfactoryAndPhysicalCheckResultNull() {
    validatorMocking();
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(SATISFACTORY)
        .build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckSatisfactoryAndIdentityCheckNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(SATISFACTORY)
        .physicalCheckResult(NOT_SATISFACTORY)
        .build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }


  @Test
  void isValid_returnsFalse_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableAndPhysicalCheckResultNull() {
    validatorMocking();
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableAndPhysicalCheckResultNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .physicalCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }


  @Test
  void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndDecisionNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableFalse() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(false).build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }
}
