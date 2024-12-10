package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.EnumSource.Mode;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.AnimalCertification;

class ImpPortOfExitDateInFutureValidatorTest {

  private ImpPortOfExitDateInFutureValidator validator;

  private PartOne partOne;

  @BeforeEach
  void setUp() {
    validator = new ImpPortOfExitDateInFutureValidator();
    partOne = new PartOne();
  }

  @Test
  void validatorShouldReturnTrueIfPartOneIsNull() {
    partOne = null;

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnTrueIfCommoditiesIsNull() {
    partOne.setCommodities(null);

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnTrueIfAnimalCertificationIsNull() {
    partOne.setCommodities(Commodities.builder().build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @ParameterizedTest
  @EnumSource(value = AnimalCertification.class, mode = Mode.EXCLUDE, names = {"TRANSIT"})
  void validatorShouldReturnTrueIfAnimalCertificationIsNotTransit(
      AnimalCertification animalCertification) {
    partOne.setCommodities(Commodities.builder().animalsCertifiedAs(animalCertification).build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnTrueIfAnimalCertificationIsTransitAndThePortOfExitDateIsNull() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  void
      validatorShouldReturnFalseIfAnimalCertificationIsTransitAndThePortOfExitDateIsEarlierThanToday() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());
    partOne.setPortOfExitDate(LocalDate.now().minusDays(1));

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnTrueIfAnimalCertificationIsTransitAndThePortOfExitDateIsToday() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());
    partOne.setPortOfExitDate(LocalDate.now());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }
}
