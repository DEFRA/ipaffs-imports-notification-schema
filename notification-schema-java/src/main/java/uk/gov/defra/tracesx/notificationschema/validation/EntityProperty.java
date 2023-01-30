package uk.gov.defra.tracesx.notificationschema.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Optional;

public interface EntityProperty {

  static <T extends Enum<T> & EntityProperty, A extends Annotation> Optional<A> getAnnotation(
      T property, Class<A> annotation) {
    Field field;

    try {
      field = property.getClass().getField(property.name());
    } catch (NoSuchFieldException exception) {
      throw new IllegalStateException(exception);
    }

    return Optional.ofNullable(field.getAnnotation(annotation));
  }
}
