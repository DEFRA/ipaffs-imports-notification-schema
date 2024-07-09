package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Objects;
import java.util.Optional;
import uk.gov.defra.tracesx.notificationschema.representation.ExternalReference;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ExternalSystem;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ProvideCtcMrnEnum;

public class NctsMrnRequiredValidator implements
    ConstraintValidator<NctsMrnRequired, Notification> {

  @Override
  public boolean isValid(Notification notification,
      ConstraintValidatorContext constraintValidatorContext) {

    if (validationDoesNotApply(notification)) {
      return true;
    }

    if (isMrnRequired(notification.getPartOne())) {
      return hasMrnBeenProvided(notification);
    }

    return true;
  }

  private boolean validationDoesNotApply(Notification notification) {
    PartOne partOne = notification.getPartOne();

    return Objects.isNull(partOne)
        || Objects.isNull(partOne.getProvideCtcMrn())
        || Objects.isNull(notification.getExternalReferences());
  }

  private boolean isMrnRequired(PartOne partOne) {
    return partOne.getProvideCtcMrn() == ProvideCtcMrnEnum.YES;
  }

  private boolean hasMrnBeenProvided(Notification notification) {
    Optional<ExternalReference> externalReference = notification.getExternalReferences().stream()
        .filter(reference -> reference.getSystem() == ExternalSystem.NCTS)
        .findFirst();

    return externalReference.isPresent();
  }
}
