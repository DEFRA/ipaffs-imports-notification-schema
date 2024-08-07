package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;

public class LaboratoryTestsNotAddedValidator
    implements ConstraintValidator<LaboratoryTestsNotAdded, PartTwo> {

  @Override
  public void initialize(LaboratoryTestsNotAdded constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(PartTwo partTwo, ConstraintValidatorContext context) {
    if (isLabTestRequired(partTwo)) {
      return true;
    }
    return atLeastOneLabTestIsAdded(partTwo);
  }

  private boolean isLabTestRequired(PartTwo partTwo) {
    return partTwo == null
        || partTwo.getLaboratoryTestsRequired() == null
        || !partTwo.getLaboratoryTestsRequired();
  }

  private boolean atLeastOneLabTestIsAdded(PartTwo partTwo) {
    return partTwo.getLaboratoryTests() != null
        && partTwo.getLaboratoryTests().getSingleLaboratoryTests() != null
        && !partTwo.getLaboratoryTests().getSingleLaboratoryTests().isEmpty();
  }
}
