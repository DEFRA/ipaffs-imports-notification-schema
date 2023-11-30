package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RUNTIME)
@Constraint(validatedBy = ChedaPurposeExitDateNotNullValidator.class)
@Documented
public @interface ChedaPurposeExitDateNotNull {

  String message() default "Add an exit date";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
