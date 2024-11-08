package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.EconomicOperator;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

@ExtendWith(MockitoExtension.class)
class ImpPlaceOfDestinationNotNullValidatorTest {

  private ImpPlaceOfDestinationNotNullValidator validator;

  private PartOne partOne;

  @BeforeEach
  void setUp() {
    validator = new ImpPlaceOfDestinationNotNullValidator();
    partOne = new PartOne();
  }

  @Test
  void validatorShouldReturnFalseIfPartOneIsNull() {
    // Given
    partOne = null;

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnFalseIfPlaceOfDestinationIsNull() {
    // Given
    partOne.setPlaceOfDestination(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnTruePlaceOfDestinationIsNotNull() {
    // Given
    EconomicOperator placeOfDestination = new EconomicOperator();
    partOne.setPlaceOfDestination(placeOfDestination);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }
}
