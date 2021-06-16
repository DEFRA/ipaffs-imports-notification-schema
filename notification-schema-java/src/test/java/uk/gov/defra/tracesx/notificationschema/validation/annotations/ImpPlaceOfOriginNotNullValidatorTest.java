package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.EconomicOperator;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

@RunWith(MockitoJUnitRunner.class)
public class ImpPlaceOfOriginNotNullValidatorTest {

  private ImpPlaceOfOriginNotNullValidator validator;

  private PartOne partOne;

  @Before
  public void setUp() {
    validator = new ImpPlaceOfOriginNotNullValidator();
    partOne = new PartOne();
  }

  @Test
  public void validatorShouldReturnFalseIfPartOneIsNull() {
    // Given
    partOne = null;

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnFalseIfPlaceOfDestinationIsNull() {
    // Given
    partOne.setConsignor(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnTruePlaceOfDestinationIsNotNull() {
    // Given
    EconomicOperator placeOfOrigin = new EconomicOperator();
    partOne.setConsignor(placeOfOrigin);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }
}