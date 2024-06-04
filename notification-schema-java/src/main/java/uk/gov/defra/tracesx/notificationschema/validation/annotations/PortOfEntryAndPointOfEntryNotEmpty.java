package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Target(TYPE)
@Retention(RUNTIME)
@Constraint(validatedBy = PortOfEntryAndPointOfEntryNotEmptyValidator.class)
@Documented
@Repeatable(PortOfEntryAndPointOfEntryNotEmpty.List.class)
public @interface PortOfEntryAndPointOfEntryNotEmpty {

  String message() default "Add a port of entry";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  @Target(TYPE)
  @Retention(RUNTIME)
  @Documented
  @interface List {

    PortOfEntryAndPointOfEntryNotEmpty[] value();
  }
}
