package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TRANSHIPMENT;
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
class NotNullTranshipmentThirdCountryValidatorTest {
  @Mock
  HibernateConstraintValidatorContext hibernateConstraintValidatorContextMock;
  @Mock
  ConstraintValidatorContext constraintValidatorContextMock;
  @Mock
  HibernateConstraintViolationBuilder hibernateConstraintViolationBuilder;
  @Mock
  ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext nodeBuilderContextMock;
  private NotNullTranshipmentThirdCountryValidator validator;
  private Decision decision;

  @BeforeEach
  void setUp() {
    validator = new NotNullTranshipmentThirdCountryValidator();
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
  void isValid_ReturnsFalse_WhenTranshipmentBipIsNull() {
    validatorMocking();
    decision.setDecision(ACCEPTABLE_FOR_TRANSHIPMENT);
    decision.setTranshipmentThirdCountry(null);

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_ReturnsTrue_WhenTranshipmentThirdCountryIsNullAndAcceptableForTransit() {
    decision.setDecision(ACCEPTABLE_FOR_TRANSIT);
    decision.setTranshipmentThirdCountry(null);

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isTrue();
  }

  @Test
  void isValid_ReturnsFalse_WhenTranshipmentThirdCountryIsEmptyString() {
    validatorMocking();
    decision.setDecision(ACCEPTABLE_FOR_TRANSHIPMENT);
    decision.setTranshipmentThirdCountry("");

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isFalse();
  }

  @Test
  void isValid_ReturnsTrue_WhenDecisionIsAcceptableForTranshipment() {
    decision.setDecision(ACCEPTABLE_FOR_TRANSHIPMENT);
    decision.setTranshipmentThirdCountry("AF");

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isTrue();
  }
}
