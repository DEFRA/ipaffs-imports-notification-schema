package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = QuantityImpValidator.class)
@Documented
public @interface QuantityImp {

  String message() default "Quantity must be entered";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
