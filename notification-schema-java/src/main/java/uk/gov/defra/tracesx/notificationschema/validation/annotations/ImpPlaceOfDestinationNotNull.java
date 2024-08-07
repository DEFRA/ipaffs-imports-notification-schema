package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = ImpPlaceOfDestinationNotNullValidator.class)
@Documented
public @interface ImpPlaceOfDestinationNotNull {

  String message() default "What is the place of destination";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
