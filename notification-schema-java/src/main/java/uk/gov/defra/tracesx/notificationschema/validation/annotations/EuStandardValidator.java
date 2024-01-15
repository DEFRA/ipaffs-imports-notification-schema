package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.ReportAsSingleViolation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

@Documented
@Constraint(validatedBy = EuStandardValidatorImpl.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE_USE})
@ReportAsSingleViolation
public @interface EuStandardValidator {

  String message() default "EU standard";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  Result[] excluded() default {};
}
