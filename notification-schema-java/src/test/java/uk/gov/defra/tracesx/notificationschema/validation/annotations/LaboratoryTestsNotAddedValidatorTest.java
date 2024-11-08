package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.LaboratoryTests;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.SingleLaboratoryTest;

class LaboratoryTestsNotAddedValidatorTest {

  private LaboratoryTestsNotAddedValidator validator;

  @BeforeEach
  void setUp() {
    validator = new LaboratoryTestsNotAddedValidator();
  }

  @Test
  void testThatValidatorReturnsTrueIfNullPassed() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueIfIsLaboratoryTestsNotAddedNull() {
    PartTwo partTwo = new PartTwo();

    assertThat(validator.isValid(partTwo, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueWhenLaboratoryTestsRequiredIsFalse() {
    PartTwo partTwo = new PartTwo();
    partTwo.setLaboratoryTestsRequired(FALSE);

    assertThat(validator.isValid(partTwo, null)).isTrue();
  }

  @Test
  void
  testThatValidatorReturnsFalseWhenLaboratoryTestsRequiredIsTrueAndLaboratoryTestsNull() {
    PartTwo partTwo = new PartTwo();
    partTwo.setLaboratoryTestsRequired(TRUE);

    assertThat(validator.isValid(partTwo, null)).isFalse();
  }

  @Test
  void
  testThatValidatorReturnsFalseWhenLaboratoryTestsRequiredIsTrueAndEmptyLaboratoryTestsList() {
    PartTwo partTwo = new PartTwo();
    partTwo.setLaboratoryTestsRequired(TRUE);
    partTwo.setLaboratoryTests(new LaboratoryTests());

    assertThat(validator.isValid(partTwo, null)).isFalse();
  }

  @Test
  void
  testThatValidatorReturnsTrueWhenLaboratoryTestsRequiredIsTrueAndLaboratoryTestsListWithOneTest() {
    PartTwo partTwo = new PartTwo();
    partTwo.setLaboratoryTestsRequired(TRUE);
    LaboratoryTests laboratoryTests = new LaboratoryTests();
    laboratoryTests.setSingleLaboratoryTests(Collections.singletonList(new SingleLaboratoryTest()));
    partTwo.setLaboratoryTests(laboratoryTests);

    assertThat(validator.isValid(partTwo, null)).isTrue();
  }
}
