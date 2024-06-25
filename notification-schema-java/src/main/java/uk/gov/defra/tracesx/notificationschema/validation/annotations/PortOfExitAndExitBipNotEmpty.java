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
@Constraint(validatedBy = PortOfExitAndExitBipNotEmptyValidator.class)
@Documented
public @interface PortOfExitAndExitBipNotEmpty {

  String message() default "Add the port of exit";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
