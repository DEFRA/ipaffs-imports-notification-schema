package uk.gov.defra.tracesx.notificationschema.validation;

import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;

public class EntityPropertyTest {

  @Test
  public void getAnnotation_ReturnsAnnotation() throws NoSuchFieldException {

    DecisionEnum property = DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET;
    Field field = property.getClass().getField(property.name());
    Class<CVEDA> annotation = CVEDA.class;

    assertThat(EntityProperty.getAnnotation(property, annotation)).hasValue(
        field.getAnnotation(annotation));
  }
}
