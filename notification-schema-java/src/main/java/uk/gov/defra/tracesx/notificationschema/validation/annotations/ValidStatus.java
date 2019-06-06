package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidStatusValidator.class)
@Documented
public @interface ValidStatus {

  String message() default "Invalid status due to type";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
