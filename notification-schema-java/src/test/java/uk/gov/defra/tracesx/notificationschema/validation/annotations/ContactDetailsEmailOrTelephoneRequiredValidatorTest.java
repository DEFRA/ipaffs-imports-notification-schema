package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.ConstraintValidatorContext.ConstraintViolationBuilder.NodeBuilderCustomizableContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;
import org.hibernate.validator.constraintvalidation.HibernateConstraintViolationBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.ContactDetails;

@RunWith(MockitoJUnitRunner.class)
public class ContactDetailsEmailOrTelephoneRequiredValidatorTest {

  private final ContactDetailsEmailOrTelephoneRequiredValidator testSubject = new ContactDetailsEmailOrTelephoneRequiredValidator();
  @Mock
  private ContactDetailsEmailOrTelephoneRequired constraintAnnotation;
  @Mock
  private ContactDetails contactDetails;
  @Mock
  private ConstraintValidatorContext context;

  @Test
  public void initialize_InitialiseWithMessage() {
    testSubject.initialize(constraintAnnotation);
    verify(constraintAnnotation, times(1)).message();
  }

  @Test
  public void isValid_WhenValidEmail_ThenReturnValid() {
    when(contactDetails.getEmail()).thenReturn("contactus@mail.com");
    assertThat(testSubject.isValid(contactDetails, context)).isTrue();
  }

  @Test
  public void isValid_WhenValidTelephone_ThenReturnValid() {
    when(contactDetails.getTelephone()).thenReturn("07407414474");
    assertThat(testSubject.isValid(contactDetails, context)).isTrue();
  }

  @Test
  public void isValid_WhenNullDetails_ThenReturnInvalid() {
    HibernateConstraintValidatorContext validatorContext = mock(
        HibernateConstraintValidatorContext.class);
    when(context.unwrap(HibernateConstraintValidatorContext.class)).thenReturn(validatorContext);
    HibernateConstraintViolationBuilder hibernateConstraintViolationBuilder = mock(HibernateConstraintViolationBuilder.class);
    when(validatorContext.buildConstraintViolationWithTemplate(any())).thenReturn(
        hibernateConstraintViolationBuilder);
    NodeBuilderCustomizableContext propertyNode = mock(NodeBuilderCustomizableContext.class);
    when(hibernateConstraintViolationBuilder.addPropertyNode(anyString())).thenReturn(propertyNode);
    ConstraintValidatorContext constraintViolation = mock(ConstraintValidatorContext.class);
    when(propertyNode.addConstraintViolation()).thenReturn(constraintViolation);

    assertThat(testSubject.isValid(contactDetails, context)).isFalse();
  }
}
