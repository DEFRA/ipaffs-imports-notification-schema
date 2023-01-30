package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = ImpPortOfExitDateNotNullValidator.class)
@Documented
public @interface ImpPortOfExitDateNotNull {

  String message() default "Port of exit date must be entered";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
