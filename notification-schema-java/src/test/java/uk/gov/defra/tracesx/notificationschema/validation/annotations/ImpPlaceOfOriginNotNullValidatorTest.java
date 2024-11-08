package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.EconomicOperator;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

@ExtendWith(MockitoExtension.class)
class ImpPlaceOfOriginNotNullValidatorTest {

  private ImpPlaceOfOriginNotNullValidator validator;

  private PartOne partOne;

  @BeforeEach
  void setUp() {
    validator = new ImpPlaceOfOriginNotNullValidator();
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
    partOne.setConsignor(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnTruePlaceOfDestinationIsNotNull() {
    // Given
    EconomicOperator placeOfOrigin = new EconomicOperator();
    partOne.setConsignor(placeOfOrigin);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }
}
