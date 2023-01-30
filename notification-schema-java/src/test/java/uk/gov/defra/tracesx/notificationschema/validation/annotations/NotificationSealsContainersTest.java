package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.NotificationSealsContainers;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationHighRiskNonChedppFieldValidation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class NotificationSealsContainersTest {

  private static final Validator VALIDATOR =
      Validation.byDefaultProvider()
          .configure()
          .messageInterpolator(new ParameterMessageInterpolator())
          .buildValidatorFactory()
          .getValidator();

  @Test
  public void validation_ReturnsNoViolations_WhenContainerNumberProvided() {

    NotificationSealsContainers sealsContainers = new NotificationSealsContainers();
    sealsContainers.setContainerNumber("12345675");
    Set<ConstraintViolation<NotificationSealsContainers>> violations = VALIDATOR.validate(
        sealsContainers,
        NotificationHighRiskNonChedppFieldValidation.class);

    assertThat(violations).isEmpty();
  }

  @Test
  public void validation_ReturnsViolation_WhenContainerNumberIsNotProvided() {

    NotificationSealsContainers sealsContainers = new NotificationSealsContainers();
    Set<ConstraintViolation<NotificationSealsContainers>> violations = VALIDATOR.validate(
        sealsContainers,
        NotificationHighRiskNonChedppFieldValidation.class);

    assertThat(violations).hasSize(1)
        .first()
        .extracting(ConstraintViolation::getMessage)
        .isEqualTo("Enter container or road trailer number");
  }
}
