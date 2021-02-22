package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

@RunWith(MockitoJUnitRunner.class)
public class ImpPortOfEntryValidatorTest {

  private ImpPortOfEntryValidator validator;

  private PartOne partOne;

  @Before
  public void setUp() {
    validator = new ImpPortOfEntryValidator();
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
  public void validatorShouldReturnFalseIfThePortOfEntryFieldIsNull() {
    // Given
    partOne.setPortOfEntry(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnFalseIfThePortOfEntryFieldIsBlank() {
    // Given
    partOne.setPortOfEntry("");

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnTrueIfThePortOfEntryFieldHasAValue() {
    // Given
    partOne.setPortOfEntry("Some port of entry");

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertTrue(result);
  }
}
