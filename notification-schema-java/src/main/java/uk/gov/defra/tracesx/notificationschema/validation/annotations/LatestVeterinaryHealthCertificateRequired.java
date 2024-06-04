package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = LatestVeterinaryHealthCertificateRequiredValidator.class)
@Documented
public @interface LatestVeterinaryHealthCertificateRequired {

  String message() default "{uk.gov.defra.tracesx.notificationschema.representation.partone"
    + ".veterinaryInformation.properties.accompanyingDocuments.must.have.latest.veterinary"
      + ".document}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
