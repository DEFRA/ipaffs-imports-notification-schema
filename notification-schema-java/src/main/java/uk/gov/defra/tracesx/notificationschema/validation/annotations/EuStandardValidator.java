package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
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
