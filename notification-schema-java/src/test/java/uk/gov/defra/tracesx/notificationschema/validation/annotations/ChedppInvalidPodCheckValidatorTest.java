package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.EconomicOperator;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

@ExtendWith(MockitoExtension.class)
class ChedppInvalidPodCheckValidatorTest {

  private ChedppInvalidPodCheckValidator validator;
  private PartOne partOne;
  private Commodities commodities;
  private EconomicOperator pod;

  @BeforeEach
  void setup() {
    validator = new ChedppInvalidPodCheckValidator();
    partOne = new PartOne();
    commodities = new Commodities();
    pod = new EconomicOperator();
  }

  @Test
  void validatorShouldReturnTrueIfPartOneIsNull() {
    // When
    boolean result = validator.isValid(null, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnTrueIfCommoditiesIsNull() {
    // Given
    partOne.setCommodities(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnFalseIfPodIsSetForNonPodGroupCountry() {
    // Given
    commodities.setCountryOfOriginIsPodCountry(Boolean.FALSE);
    partOne.setCommodities(commodities);
    partOne.setPod(pod);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnTrueIfPodIsSetForPodGroupCountry() {
    // Given
    commodities.setCountryOfOriginIsPodCountry(Boolean.TRUE);
    partOne.setCommodities(commodities);
    partOne.setPod(pod);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnTrueIfPodIsNull() {
    // Given
    partOne.setPod(null);
    commodities.setCountryOfOriginIsPodCountry(Boolean.FALSE);
    partOne.setCommodities(commodities);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  void validatorShouldReturnTrueIfPodCountryGroupIsNull() {
    // Given
    commodities.setCountryOfOriginIsPodCountry(null);
    partOne.setCommodities(commodities);
    partOne.setPod(pod);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }
}
