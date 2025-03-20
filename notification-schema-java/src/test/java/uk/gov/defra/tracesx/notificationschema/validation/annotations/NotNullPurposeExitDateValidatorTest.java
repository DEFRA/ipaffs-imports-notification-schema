package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;

class NotNullPurposeExitDateValidatorTest {

  private NotNullPurposeExitDateValidator validator;


  @BeforeEach
  void setUp() {
    validator = new NotNullPurposeExitDateValidator();
  }

  @Test
  void shouldReturnTrueIfPartOneIsNull() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  void shouldReturnTrueIfPurposeIsNull() {
    PartOne partOne = PartOne.builder().build();
    assertTrue(validator.isValid(partOne, null));
  }

  @Test
  void shouldReturnTrueIfForImportOrAdmissionIsNull() {
    PartOne partOne = PartOne.builder()
        .purpose(Purpose.builder().build())
        .build();
    assertTrue(validator.isValid(partOne, null));
  }

  @Test
  void shouldReturnTrueIfNotTemporaryAdmissionHorses() {
    PartOne partOne = PartOne.builder()
        .purpose(Purpose.builder()
          .forImportOrAdmission(ForImportOrAdmissionEnum.HORSES_RE_ENTRY)
          .build())
        .build();
    assertTrue(validator.isValid(partOne, null));
  }

  @Test
  void shouldReturnFalseIfTemporaryAdmissionHorsesAndExitDateIsNull() {
    PartOne partOne = PartOne.builder()
        .purpose(Purpose.builder()
          .forImportOrAdmission(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES)
          .build())
        .build();
    assertFalse(validator.isValid(partOne, null));
  }

  @Test
  void shouldReturnTrueIfTemporaryAdmissionHorsesAndExitDateIsNotNull() {
    PartOne partOne = PartOne.builder()
        .purpose(Purpose.builder()
            .forImportOrAdmission(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES)
            .exitDate("2025-10-25")
            .build())
        .build();
    assertTrue(validator.isValid(partOne, null));
  }
}
