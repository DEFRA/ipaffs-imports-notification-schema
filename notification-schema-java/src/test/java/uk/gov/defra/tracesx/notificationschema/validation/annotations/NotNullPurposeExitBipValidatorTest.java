package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum.DEFINITIVE_IMPORT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PurposeGroupEnum.RE_IMPORT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PurposeGroupEnum.TRANSIT_TO_3RD_COUNTRY;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.Purpose;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ForImportOrAdmissionEnum;

@ExtendWith(MockitoExtension.class)
class NotNullPurposeExitBipValidatorTest {

  private NotNullPurposeExitBipValidator validator;

  private final PartOne partOne = new PartOne();

  @BeforeEach
  void setUp() {
    validator = new NotNullPurposeExitBipValidator();
    partOne.setPurpose(new Purpose());
  }

  @Test
  void validatorShouldReturnTrueIfPurposeIsNull() {
    // Given
    partOne.setPurpose(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnTrueIfForImportOrAdmissionIsTemporaryAdmissionHorsesAndPurposeExitBipIsNotNull() {
    // Given
    partOne.getPurpose().setForImportOrAdmission(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES);
    partOne.getPurpose().setExitBIP("Some BIP");

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnFalseIfForImportOrAdmissionIsTemporaryAdmissionHorsesAndPurposeExitBipIsNull() {
    // Given
    partOne.getPurpose().setForImportOrAdmission(ForImportOrAdmissionEnum.TEMPORARY_ADMISSION_HORSES);
    partOne.getPurpose().setExitBIP(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnTrueIfForImportOrAdmissionIsHorsesReEntry() {
    // Given
    partOne.getPurpose().setForImportOrAdmission(ForImportOrAdmissionEnum.HORSES_RE_ENTRY);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenForImportOrAdmissionIsDefinitiveImport() {
    // Given
    partOne.getPurpose().setForImportOrAdmission(DEFINITIVE_IMPORT);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void isValid_ReturnsFalse_WhenPurposeGroupTransitToThirdCountryAndPurposeExitBipIsNull() {
    // Given
    partOne.getPurpose().setPurposeGroup(TRANSIT_TO_3RD_COUNTRY);
    partOne.getPurpose().setExitBIP(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void isValid_ReturnsTrue_WhenPurposeGroupTransitToThirdCountryAndPurposeExitBipNotNull() {
    // Given
    partOne.getPurpose().setPurposeGroup(TRANSIT_TO_3RD_COUNTRY);
    partOne.getPurpose().setExitBIP("Exit Bip");

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void isValid_ReturnsTrue_WhenPurposeGroupNotTransitToThirdCountry() {
    // Given
    partOne.getPurpose().setPurposeGroup(RE_IMPORT);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }
}
