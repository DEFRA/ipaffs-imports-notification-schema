package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.EconomicOperator;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

@RunWith(MockitoJUnitRunner.class)
public class ChedppInvalidPodCheckValidatorTest {

  private ChedppInvalidPodCheckValidator validator;
  private PartOne partOne;
  private Commodities commodities;
  private EconomicOperator pod;

  @Before
  public void setup() {
    validator = new ChedppInvalidPodCheckValidator();
    partOne = new PartOne();
    commodities = new Commodities();
    pod = new EconomicOperator();
  }

  @Test
  public void validatorShouldReturnTrueIfPartOneIsNull() {
    // When
    boolean result = validator.isValid(null, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validatorShouldReturnTrueIfCommoditiesIsNull() {
    // Given
    partOne.setCommodities(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }

  @Test
  public void validatorShouldReturnFalseIfPodIsSetForNonPodGroupCountry() {
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
  public void validatorShouldReturnTrueIfPodIsSetForPodGroupCountry() {
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
  public void validatorShouldReturnTrueIfPodIsNull() {
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
  public void validatorShouldReturnTrueIfPodCountryGroupIsNull() {
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