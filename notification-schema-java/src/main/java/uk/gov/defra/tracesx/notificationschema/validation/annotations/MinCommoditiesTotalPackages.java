package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = MinCommoditiesTotalPackagesValidator.class)
@Documented
public @interface MinCommoditiesTotalPackages {
  String message() default "Invalid Total Packages Weight";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

}
