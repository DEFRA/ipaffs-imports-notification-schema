package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.RetrospectiveCloningMergeMethod;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface RetrospectiveCloningProperty {
  RetrospectiveCloningMergeMethod mergeMethod() default RetrospectiveCloningMergeMethod.NONE;
}
