package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

@ExtendWith(MockitoExtension.class)
class ImpPortOfEntryValidatorTest {

  private ImpPortOfEntryValidator validator;

  private PartOne partOne;

  @BeforeEach
  void setUp() {
    validator = new ImpPortOfEntryValidator();
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
  void validatorShouldReturnFalseIfThePortOfEntryFieldIsNull() {
    // Given
    partOne.setPortOfEntry(null);

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnFalseIfThePortOfEntryFieldIsBlank() {
    // Given
    partOne.setPortOfEntry("");

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isFalse();
  }

  @Test
  void validatorShouldReturnTrueIfThePortOfEntryFieldHasAValue() {
    // Given
    partOne.setPortOfEntry("Some port of entry");

    // When
    boolean result = validator.isValid(partOne, null);

    // Then
    assertThat(result).isTrue();
  }
}
