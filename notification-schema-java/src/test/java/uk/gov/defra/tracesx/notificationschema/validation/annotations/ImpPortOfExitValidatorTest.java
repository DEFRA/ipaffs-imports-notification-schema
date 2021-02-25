package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

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

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@RunWith(Theories.class)
public class ImpPortOfExitValidatorTest {

  private ImpPortOfExitValidator validator;

  private PartOne partOne;

  @DataPoints("Non Transit AnimalCertifications")
  public static Collection<AnimalCertification> nonTransitAnimalCertifications() {
    return Arrays.stream(AnimalCertification.values())
        .filter(animalCertification -> animalCertification != AnimalCertification.TRANSIT)
        .collect(Collectors.toList());
  }

  @Before
  public void setUp() {
    validator = new ImpPortOfExitValidator();
    partOne = new PartOne();
  }

  @Test
  public void validatorShouldReturnFalseIfPartOneIsNull() {
    partOne = null;

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }

  @Test
  public void validatorShouldReturnFalseIfCommoditiesIsNull() {
    partOne.setCommodities(null);

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }

  @Test
  public void validatorShouldReturnTrueIfAnimalCertificationIsNull() {
    partOne.setCommodities(Commodities.builder().build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Theory
  public void validatorShouldReturnTrueIfAnimalCertificationIsSetAndNotTransit(
      @FromDataPoints("Non Transit AnimalCertifications") AnimalCertification animalCertification) {
    partOne.setCommodities(Commodities.builder().animalsCertifiedAs(animalCertification).build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }

  @Test
  public void validatorShouldReturnFalseIfAnimalCertificationIsTransitAndThePortOfExitIsNull() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }

  @Test
  public void validatorShouldReturnFalseIfAnimalCertificationIsTransitAndThePortOfExitIsBlank() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());
    partOne.setPortOfExit("");

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }

  @Test
  public void
      validatorShouldReturnFalseIfAnimalCertificationIsTransitAndThePortOfExitIsWhitespace() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());
    partOne.setPortOfExit("  \t\t\t");

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isFalse();
  }

  @Test
  public void validatorShouldReturnTrueIfAnimalCertificationIsTransitAndThePortOfExitIsPopulated() {
    partOne.setCommodities(
        Commodities.builder().animalsCertifiedAs(AnimalCertification.TRANSIT).build());
    partOne.setPortOfExit("Portcullis");

    boolean result = validator.isValid(partOne, null);

    assertThat(result).isTrue();
  }
}
