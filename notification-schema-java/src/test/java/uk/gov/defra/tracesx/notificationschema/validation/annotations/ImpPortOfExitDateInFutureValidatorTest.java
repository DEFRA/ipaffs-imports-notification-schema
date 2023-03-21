package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.AnimalCertification;

@RunWith(Theories.class)
public class ImpPortOfExitDateInFutureValidatorTest {

  private ImpPortOfExitDateInFutureValidator validator;

  private PartOne partOne;

  @DataPoints("Non Transit AnimalCertifications")
  public static Collection<AnimalCertification> nonTransitAnimalCertifications() {
    return Arrays.stream(AnimalCertification.values())
        .filter(animalCertification -> animalCertification != AnimalCertification.TRANSIT)
        .collect(Collectors.toList());
  }

  @Before
  public void setUp() {
    validator = new ImpPortOfExitDateInFutureValidator();
    partOne = new PartOne();
  }

  @Test
  public void validatorShouldReturnTrueIfPartOneIsNull() {
    partOne = null;

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  public void validatorShouldReturnTrueIfCommoditiesIsNull() {
    partOne.setCommodities(null);

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  public void validatorShouldReturnTrueIfAnimalCertificationIsNull() {
    partOne.setCommodities(Commodities.builder().build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Theory
  public void validatorShouldReturnTrueIfAnimalCertificationIsNotTransit(
      @FromDataPoints("Non Transit AnimalCertifications") AnimalCertification animalCertification) {
    partOne.setCommodities(Commodities.builder().animalsCertifiedAs(animalCertification).build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  public void validatorShouldReturnTrueIfAnimalCertificationIsTransitAndThePortOfExitDateIsNull() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  public void
      validatorShouldReturnFalseIfAnimalCertificationIsTransitAndThePortOfExitDateIsEarlierThanToday() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());
    partOne.setPortOfExitDate(LocalDate.now().minusDays(1));

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }

  @Test
  public void validatorShouldReturnTrueIfAnimalCertificationIsTransitAndThePortOfExitDateIsToday() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());
    partOne.setPortOfExitDate(LocalDate.now());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }
}
