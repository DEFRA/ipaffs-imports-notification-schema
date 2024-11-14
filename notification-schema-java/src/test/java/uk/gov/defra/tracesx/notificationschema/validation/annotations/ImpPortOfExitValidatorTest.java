package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.AnimalCertification;

class ImpPortOfExitValidatorTest {

  private ImpPortOfExitValidator validator;

  private PartOne partOne;

  @BeforeEach
  void setUp() {
    validator = new ImpPortOfExitValidator();
    partOne = new PartOne();
  }

  @Test
  void validatorShouldReturnFalseIfPartOneIsNull() {
    partOne = null;

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnFalseIfCommoditiesIsNull() {
    partOne.setCommodities(null);

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnTrueIfAnimalCertificationIsNull() {
    partOne.setCommodities(Commodities.builder().build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @ParameterizedTest
  @EnumSource(value = AnimalCertification.class, mode = Mode.EXCLUDE, names = {"TRANSIT"})
  void validatorShouldReturnTrueIfAnimalCertificationIsSetAndNotTransit(
      AnimalCertification animalCertification) {
    partOne.setCommodities(Commodities.builder().animalsCertifiedAs(animalCertification).build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnFalseIfAnimalCertificationIsTransitAndThePortOfExitIsNull() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnFalseIfAnimalCertificationIsTransitAndThePortOfExitIsBlank() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());
    partOne.setPortOfExit("");

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }

  @Test
  void
      validatorShouldReturnFalseIfAnimalCertificationIsTransitAndThePortOfExitIsWhitespace() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());
    partOne.setPortOfExit("  \t\t\t");

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnTrueIfAnimalCertificationIsTransitAndThePortOfExitIsPopulated() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());
    partOne.setPortOfExit("Portcullis");

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }
}
