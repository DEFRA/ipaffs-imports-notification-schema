package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PhysicalCheckResultValidator.class)
@Documented
public @interface PhysicalCheckResult {

  String message() default "Reason physical check not done";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
