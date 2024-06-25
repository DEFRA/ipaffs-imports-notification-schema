package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ChedppInvalidPodCheckValidator.class)
@Documented
public @interface ChedppInvalidPodCheck {

  String message() default "You must select an EU country if you are using a POD";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
