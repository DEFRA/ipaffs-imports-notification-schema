package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

@RunWith(MockitoJUnitRunner.class)
public class ChedppCustomsReferenceRequiredValidatorTest {

  private ChedppCustomsReferenceRequiredValidator validator;

  private PartOne partOne;

  @Before
  public void setUp() {
    validator = new ChedppCustomsReferenceRequiredValidator();
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
  public void validatorShouldReturnFalseIfCustomsReferenceNumberIsNull() {
    // Given
    partOne.setCustomsReferenceNumber(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnFalseIfCustomsReferenceNumberIsEmpty() {
    // Given
    partOne.setCustomsReferenceNumber("");

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnFalseIfCustomsReferenceNumberIsBlankSpace() {
    // Given
    partOne.setCustomsReferenceNumber("  ");

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnTrueIfCustomsReferenceNumberIsValid() {
    // Given
    partOne.setCustomsReferenceNumber("custom_reference_number_123");

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }
}