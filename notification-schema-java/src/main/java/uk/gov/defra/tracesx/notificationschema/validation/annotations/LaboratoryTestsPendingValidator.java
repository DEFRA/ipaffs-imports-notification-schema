package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.LaboratoryTestResult;
import uk.gov.defra.tracesx.notificationschema.representation.LaboratoryTests;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.SingleLaboratoryTest;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Conclusion;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.TestReason;

import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LaboratoryTestsPendingValidator
    implements ConstraintValidator<LaboratoryTestsPending, PartTwo> {

  @Override
  public void initialize(LaboratoryTestsPending constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(PartTwo partTwo, ConstraintValidatorContext context) {
    if (isLabTestRequired(partTwo)) {
      return true;
    }
    return !atLeastOneLabTestIsPendingAndSuspicious(partTwo);
  }

  private boolean isLabTestRequired(PartTwo partTwo) {
    return partTwo == null
        || partTwo.getLaboratoryTestsRequired() == null
        || !partTwo.getLaboratoryTestsRequired();
  }

  private boolean atLeastOneLabTestIsPendingAndSuspicious(PartTwo partTwo) {
    final LaboratoryTests laboratoryTests = partTwo.getLaboratoryTests();
    return hasAtLeastOneLaboratoryTest(laboratoryTests)
        && requiresResultsWhenPending(laboratoryTests)
        && isThereAPendingTestResult(laboratoryTests.getSingleLaboratoryTests());
  }

  private boolean requiresResultsWhenPending(LaboratoryTests laboratoryTests) {
    return laboratoryTests.getTestReason() != null
        && (laboratoryTests.getTestReason() == TestReason.SUSPICIOUS
        || laboratoryTests.getTestReason() == TestReason.REENFORCED
        || laboratoryTests.getTestReason() == TestReason.INTENSIFIED_CONTROLS
        || laboratoryTests.getTestReason() == TestReason.LATENT_INFECTION_SAMPLING);
  }

  private boolean hasAtLeastOneLaboratoryTest(LaboratoryTests laboratoryTests) {
    return laboratoryTests != null && laboratoryTests.getSingleLaboratoryTests() != null;
  }

  private boolean isThereAPendingTestResult(List<SingleLaboratoryTest> singleLaboratoryTests) {
    return singleLaboratoryTests.stream()
        .anyMatch(
            singleLaboratoryTest ->
                resultsAreNotAvailableOrPending(singleLaboratoryTest.getLaboratoryTestResult()));
  }

  private boolean resultsAreNotAvailableOrPending(LaboratoryTestResult laboratoryTestResult) {
    return laboratoryTestResult == null || isPendingResult(laboratoryTestResult);
  }

  private boolean isPendingResult(LaboratoryTestResult laboratoryTestResult) {
    return laboratoryTestResult != null
        && laboratoryTestResult.getConclusion() == Conclusion.PENDING;
  }
}
