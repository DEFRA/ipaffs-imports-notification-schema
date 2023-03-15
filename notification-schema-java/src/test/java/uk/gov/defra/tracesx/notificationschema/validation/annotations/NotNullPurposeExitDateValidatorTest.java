package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;

@RunWith(MockitoJUnitRunner.class)
public class NotNullPurposeExitDateValidatorTest {

  private NotNullPurposeExitDateValidator validator;

  private PartOne partOne = new PartOne();

  @Before
  public void setUp() {
    validator = new NotNullPurposeExitDateValidator();
    partOne.setPurpose(new Purpose());
  }

  @Test
  public void validatorShouldReturnTrueIfPurposeIsNull() {
    // Given
    partOne.setPurpose(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }

  @Test
  public void validatorShouldReturnTrueIfForImportOrAdmissionIsTemporaryAdmissionHorsesAndPurposeExitDateIsNotNull() {
    // Given
    partOne.getPurpose().setForImportOrAdmission(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES);
    partOne.getPurpose().setExitDate("2020-12-06 12:00:00");

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }

  @Test
  public void validatorShouldReturnFalseIfForImportOrAdmissionIsTemporaryAdmissionHorsesAndPurposeExitDateIsNull() {
    // Given
    partOne.getPurpose().setForImportOrAdmission(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES);
    partOne.getPurpose().setExitDate(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnTrueIfForImportOrAdmissionIsHorsesReEntry() {
    // Given
    partOne.getPurpose().setForImportOrAdmission(ForImportOrAdmissionEnum.HORSES_RE_ENTRY);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }

  @Test
  public void validatorShouldReturnTrueIfForImportOrAdmissionIsDefinitiveImport() {
    // Given
    partOne.getPurpose().setForImportOrAdmission(ForImportOrAdmissionEnum.DEFINITIVE_IMPORT);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }
}
