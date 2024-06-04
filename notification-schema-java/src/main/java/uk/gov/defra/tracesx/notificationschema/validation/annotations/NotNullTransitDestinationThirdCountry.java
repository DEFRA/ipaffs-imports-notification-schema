package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = NotNullTransitDestinationThirdCountryValidator.class)
@Documented
public @interface NotNullTransitDestinationThirdCountry {
  String message() default "Transit exit country must be selected";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
