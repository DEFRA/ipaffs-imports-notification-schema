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
@Constraint(validatedBy = ChedpPhysicalCheckValidator.class)
@Documented
public @interface ChedpPhysicalCheck {

  String message() default "{uk.gov.defra.tracesx.notificationschema.representation.parttwo"
      + ".consignmentcheck.physicalcheck.not.null}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
