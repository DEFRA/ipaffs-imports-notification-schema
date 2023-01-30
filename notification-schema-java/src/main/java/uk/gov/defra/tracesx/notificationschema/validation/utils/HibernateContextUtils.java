package uk.gov.defra.tracesx.notificationschema.validation.utils;

import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorContext;

import javax.validation.ConstraintValidatorContext;

public class HibernateContextUtils {

  private HibernateContextUtils() {
  }

  public static void setHibernateContext(ConstraintValidatorContext context,
                                         String message, String propertyPath) {
    HibernateConstraintValidatorContext hibernateContext =
        context.unwrap(HibernateConstraintValidatorContext.class);
    hibernateContext.disableDefaultConstraintViolation();
    hibernateContext
        .buildConstraintViolationWithTemplate(message)
        .addPropertyNode(propertyPath)
        .addConstraintViolation();
  }
}
