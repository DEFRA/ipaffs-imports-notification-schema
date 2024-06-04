package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({TYPE, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ChedppSealsAndContainersValidator.class)
@Documented
public @interface ChedppSealsAndContainers {

  String message() default "Enter either a seal or container number";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
