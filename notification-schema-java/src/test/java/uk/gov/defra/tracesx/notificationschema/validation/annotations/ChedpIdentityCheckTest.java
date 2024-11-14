package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentificationCheckType.FULL_IDENTITY_CHECK;
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
class ChedpIdentityCheckTest {

  private ChedpIdentityCheckValidator validator;
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
    validator = new ChedpIdentityCheckValidator();
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
  void isValid_returnsFalse_whenDocumentCheckNullAndIdentityCheckTypeNull() {
    validatorMocking();
    partTwo.setConsignmentCheck(new ConsignmentCheck());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_returnsFalse_whenDocumentCheckNullAndIdentityCheckResultNull() {
    validatorMocking();
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .identityCheckType(FULL_IDENTITY_CHECK)
        .build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckNullAndIdentityCheckNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .identityCheckType(FULL_IDENTITY_CHECK)
        .identityCheckResult(NOT_SATISFACTORY)
        .build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }


  @Test
  void isValid_returnsFalse_whenDocumentCheckSatisfactoryAndIdentityCheckTypeNull() {
    validatorMocking();
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(SATISFACTORY)
        .build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_returnsFalse_whenDocumentCheckSatisfactoryAndIdentityCheckResultNull() {
    validatorMocking();
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(SATISFACTORY)
        .identityCheckType(FULL_IDENTITY_CHECK)
        .build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckSatisfactoryAndIdentityCheckNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(SATISFACTORY)
        .identityCheckType(FULL_IDENTITY_CHECK)
        .identityCheckResult(NOT_SATISFACTORY)
        .build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isTrue();
  }


  @Test
  void isValid_returnsFalse_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableAndIdentityCheckTypeNull() {
    validatorMocking();
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_returnsFalse_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableAndIdentityCheckResultNull() {
    validatorMocking();
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .identityCheckType(FULL_IDENTITY_CHECK)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());

    assertThat(validator.isValid(partTwo, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableAndIdentityCheckNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .identityCheckType(FULL_IDENTITY_CHECK)
        .identityCheckResult(NOT_SATISFACTORY)
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
