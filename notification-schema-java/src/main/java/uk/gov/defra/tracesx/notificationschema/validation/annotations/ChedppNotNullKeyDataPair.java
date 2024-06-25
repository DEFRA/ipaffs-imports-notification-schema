package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = ChedppNotNullKeyDataPairValidator.class)
@Documented
@Repeatable(ChedppNotNullKeyDataPair.List.class)
public @interface ChedppNotNullKeyDataPair {

  String message() default "Invalid key data pair";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String field();

  @Target({FIELD})
  @Retention(RUNTIME)
  @Documented
  @interface List {

    ChedppNotNullKeyDataPair[] value();
  }
}
