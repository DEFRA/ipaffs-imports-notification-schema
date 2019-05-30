package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = MinValueKeyDataPairValidator.class)
@Documented
@Repeatable(MinValueKeyDataPair.List.class)
public @interface MinValueKeyDataPair {

  String message() default "Invalid key data pair";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  String field();

  @Target({FIELD})
  @Retention(RUNTIME)
  @Documented
  @interface List {

    MinValueKeyDataPair[] value();
  }
}
