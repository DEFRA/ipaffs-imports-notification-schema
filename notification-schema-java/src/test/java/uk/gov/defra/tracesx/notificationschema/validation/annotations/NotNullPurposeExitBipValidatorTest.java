package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum.DEFINITIVE_IMPORT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PurposeGroupEnum.RE_IMPORT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PurposeGroupEnum.TRANSIT_TO_3RD_COUNTRY;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;

@RunWith(MockitoJUnitRunner.class)
public class NotNullPurposeExitBipValidatorTest {

  private NotNullPurposeExitBipValidator validator;

  private PartOne partOne = new PartOne();

  @Before
  public void setUp() {
    validator = new NotNullPurposeExitBipValidator();
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
  public void validatorShouldReturnTrueIfForImportOrAdmissionIsTemporaryAdmissionHorsesAndPurposeExitBipIsNotNull() {
    // Given
    partOne.getPurpose().setForImportOrAdmission(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES);
    partOne.getPurpose().setExitBIP("Some BIP");

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }

  @Test
  public void validatorShouldReturnFalseIfForImportOrAdmissionIsTemporaryAdmissionHorsesAndPurposeExitBipIsNull() {
    // Given
    partOne.getPurpose().setForImportOrAdmission(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES);
    partOne.getPurpose().setExitBIP(null);

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
  public void isValid_ReturnsTrue_WhenForImportOrAdmissionIsDefinitiveImport() {
    // Given
    partOne.getPurpose().setForImportOrAdmission(DEFINITIVE_IMPORT);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }

  @Test
  public void isValid_ReturnsFalse_WhenPurposeGroupTransitToThirdCountryAndPurposeExitBipIsNull() {
    // Given
    partOne.getPurpose().setPurposeGroup(TRANSIT_TO_3RD_COUNTRY);
    partOne.getPurpose().setExitBIP(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void isValid_ReturnsTrue_WhenPurposeGroupTransitToThirdCountryAndPurposeExitBipNotNull() {
    // Given
    partOne.getPurpose().setPurposeGroup(TRANSIT_TO_3RD_COUNTRY);
    partOne.getPurpose().setExitBIP("Exit Bip");

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }

  @Test
  public void isValid_ReturnsTrue_WhenPurposeGroupNotTransitToThirdCountry() {
    // Given
    partOne.getPurpose().setPurposeGroup(RE_IMPORT);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }
}
