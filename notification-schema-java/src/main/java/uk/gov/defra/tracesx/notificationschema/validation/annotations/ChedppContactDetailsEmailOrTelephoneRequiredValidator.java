package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.ContactDetails;
import uk.gov.defra.tracesx.notificationschema.validation.utils.HibernateContextUtils;

public class ChedppContactDetailsEmailOrTelephoneRequiredValidator implements
    ConstraintValidator<ChedppContactDetailsEmailOrTelephoneRequired, ContactDetails> {

  private String message;

  @Override
  public void initialize(ChedppContactDetailsEmailOrTelephoneRequired constraintAnnotation) {
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
