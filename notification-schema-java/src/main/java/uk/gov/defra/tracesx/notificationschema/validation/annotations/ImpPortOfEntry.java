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
@Constraint(validatedBy = ImpPortOfEntryValidator.class)
@Documented
public @interface ImpPortOfEntry {

  String message() default "Port of entry must be entered";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
