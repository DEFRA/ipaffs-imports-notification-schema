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
public class ImpPlaceOfDestinationNotNullValidatorTest {

  private ImpPlaceOfDestinationNotNullValidator validator;

  private PartOne partOne;

  @Before
  public void setUp() {
    validator = new ImpPlaceOfDestinationNotNullValidator();
    partOne = new PartOne();
  }

  @Test
  public void validatorShouldReturnFalseIfPartOneIsNull() {
    // When
    boolean result = validator.isValid(null, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnFalseIfPlaceOfDestinationIsNull() {
    // Given
    partOne.setPlaceOfDestination(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnTrueIfPlaceOfDestinationIsNotNull() {
    // Given
    EconomicOperator placeOfDestination = new EconomicOperator();
    partOne.setPlaceOfDestination(placeOfDestination);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }
}