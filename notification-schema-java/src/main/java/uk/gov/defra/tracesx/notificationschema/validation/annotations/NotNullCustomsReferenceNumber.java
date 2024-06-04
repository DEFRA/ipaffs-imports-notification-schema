package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = NotNullCustomsReferenceNumberValidator.class)
@Documented
public @interface NotNullCustomsReferenceNumber {

  String message() default "Customs reference number must be provided";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
