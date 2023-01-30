package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.ContactDetails;
import uk.gov.defra.tracesx.notificationschema.validation.utils.HibernateContextUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContactDetailsEmailOrTelephoneRequiredValidator implements
    ConstraintValidator<ContactDetailsEmailOrTelephoneRequired, ContactDetails> {

  private String message;

  @Override
  public void initialize(ContactDetailsEmailOrTelephoneRequired constraintAnnotation) {
    message = constraintAnnotation.message();
  }

  @Override
  public boolean isValid(ContactDetails contactDetails, ConstraintValidatorContext context) {
    boolean isValid = contactDetails.getEmail() != null
        || contactDetails.getTelephone() != null;

    if (!isValid) {
      HibernateContextUtils.setHibernateContext(context,
          message,
          "email.telephone");
    }
    return isValid;
  }
}
