package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ChedppCustomsReferenceRequiredValidator.class)
@Documented
public @interface ChedppCustomsReferenceRequired {

  String message() default "Customs reference number(DUCR)";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}