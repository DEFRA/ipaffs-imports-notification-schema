package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TEMPORARY_IMPORT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TRANSIT;

import jakarta.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintViolationBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;

@ExtendWith(MockitoExtension.class)
class NotNullTemporaryExitBipValidatorTest {

  @Mock
  HibernateConstraintValidatorContext hibernateConstraintValidatorContextMock;
  @Mock
  ConstraintValidatorContext constraintValidatorContextMock;
  @Mock
  HibernateConstraintViolationBuilder hibernateConstraintViolationBuilder;
  @Mock
  ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext nodeBuilderContextMock;
  private NotNullTemporaryExitBipValidator validator;
  private Decision decision;

  @BeforeEach
  void setUp() {
    validator = new NotNullTemporaryExitBipValidator();
    this.decision = Decision.builder().build();
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
  void isValid_ReturnsTrue_WhenNoPartTwo() {
    assertThat(validator.isValid(null, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenNoDecision() {
    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenDecisionIsNull() {
    decision.setDecision(null);

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void isValid_ReturnsFalse_WhenTemporaryExitBipIsNull() {
    validatorMocking();
    decision.setDecision(ACCEPTABLE_FOR_TEMPORARY_IMPORT);
    decision.setTemporaryExitBip(null);

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_ReturnsTrue_WhenTemporaryExitBipIsNullAndAcceptableForTransit() {
    decision.setDecision(ACCEPTABLE_FOR_TRANSIT);
    decision.setTemporaryExitBip(null);

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void isValid_ReturnsFalse_WhenTemporaryExitBipIsEmptyString() {
    validatorMocking();
    decision.setDecision(ACCEPTABLE_FOR_TEMPORARY_IMPORT);
    decision.setTemporaryExitBip("");

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_ReturnsTrue_WhenDecisionIsAcceptableForTemporaryImport() {
    decision.setDecision(ACCEPTABLE_FOR_TEMPORARY_IMPORT);
    decision.setTemporaryExitBip("GBPHD1");

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isTrue();
  }

}
