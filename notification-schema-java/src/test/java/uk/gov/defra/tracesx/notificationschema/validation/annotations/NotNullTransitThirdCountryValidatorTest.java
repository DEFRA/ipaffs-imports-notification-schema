package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TRANSHIPMENT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TRANSIT;

import javax.validation.ConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;

@RunWith(MockitoJUnitRunner.class)
public class NotNullTransitThirdCountryValidatorTest {

  @DataPoints("Other decisions")
  public static final DecisionEnum[] decisions =
      new DecisionEnum[]{
          ACCEPTABLE_FOR_TRANSIT
      };
  @Mock
  HibernateConstraintValidatorContext hibernateConstraintValidatorContextMock;
  @Mock
  ConstraintValidatorContext constraintValidatorContextMock;
  @Mock
  ConstraintValidatorContext.ConstraintViolationBuilder constraintViolationBuilderMock;
  @Mock
  ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext nodeBuilderContextMock;
  private NotNullTransitThirdCountryValidator validator;
  private Decision decision;

  @Before
  public void setUp() {
    validator = new NotNullTransitThirdCountryValidator();
    this.decision = Decision.builder().build();

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
  public void isValid_ReturnsTrue_WhenNoPartTwo() {
    assertThat(validator.isValid(null, constraintValidatorContextMock)).isTrue();
  }

  @Test
  public void isValid_ReturnsTrue_WhenNoDecision() {
    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isTrue();
  }

  @Test
  public void isValid_ReturnsTrue_WhenDecisionIsNull() {
    decision.setDecision(null);

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isTrue();
  }

  @Test
  public void isValid_ReturnsFalse_WhenTransitThirdCountryIsNull() {
    decision.setDecision(ACCEPTABLE_FOR_TRANSIT);
    decision.setTransitThirdCountry(null);

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isFalse();
  }

  @Test
  public void isValid_ReturnsTrue_WhenTransitThirdCountryIsNullAndAcceptableForTranshipment() {
    decision.setDecision(ACCEPTABLE_FOR_TRANSHIPMENT);
    decision.setTransitThirdCountry(null);

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isTrue();
  }

  @Test
  public void isValid_ReturnsFalse_WhenTransitThirdCountryIsEmptyString() {
    decision.setDecision(ACCEPTABLE_FOR_TRANSIT);
    decision.setTransitThirdCountry("");

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isFalse();
  }

  @Test
  public void isValid_ReturnsTrue_WhenDecisionIsAcceptableForTransit() {
    decision.setDecision(ACCEPTABLE_FOR_TRANSIT);
    decision.setTransitThirdCountry("AF");

    assertThat(validator.isValid(decision, constraintValidatorContextMock)).isTrue();
  }
}