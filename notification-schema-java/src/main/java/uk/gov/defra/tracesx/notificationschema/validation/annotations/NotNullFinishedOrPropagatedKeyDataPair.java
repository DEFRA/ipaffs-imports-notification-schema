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
@Constraint(validatedBy = NotNullFinishedOrPropagatedKeyDataPairValidator.class)
@Documented
public @interface NotNullFinishedOrPropagatedKeyDataPair {

  String message() default "Finished or propagated";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
