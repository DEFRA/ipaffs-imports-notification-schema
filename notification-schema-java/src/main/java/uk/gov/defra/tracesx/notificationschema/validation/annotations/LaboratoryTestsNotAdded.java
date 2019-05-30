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
@Constraint(validatedBy = LaboratoryTestsNotAddedValidator.class)
@Documented
public @interface LaboratoryTestsNotAdded {

  String message() default "At least one laboratory test is required";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
