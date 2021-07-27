package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import uk.gov.defra.tracesx.notificationschema.representation.NotificationSealsContainers;

import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class SealNumberNotEmptyValidatorTest {

  private SealNumberNotEmptyValidator validator;

  private List<NotificationSealsContainers> notificationSealsContainers;

  @Before
  public void setUp() {
    validator = new SealNumberNotEmptyValidator();
    NotificationSealsContainers container = new NotificationSealsContainers();
    container.setSealNumber("valid seal number");
    notificationSealsContainers = List.of(container);
  }

  @Test
  public void validatorShouldReturnTrueIfSealContainersIsNull() {
    // Given
    notificationSealsContainers = null;
    // When
    boolean result = validator.isValid(notificationSealsContainers, null);

    // Then
    assertTrue(result);
  }

  @Test
  public void validatorShouldReturnTrueIfSealContainersIsEmpty() {
    // Given
    notificationSealsContainers = Collections.emptyList();

    // When
    boolean result = validator.isValid(notificationSealsContainers, null);

    // Then
    assertTrue(result);
  }

  @Test
  public void validatorShouldReturnFalseIfContainerSealNumberIsNull() {
    // Given
    notificationSealsContainers.get(0).setSealNumber(null);


    // When
    boolean result = validator.isValid(notificationSealsContainers, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnFalseIfContainerSealNumberIsEmpty() {
    // Given
    notificationSealsContainers.get(0).setSealNumber("");


    // When
    boolean result = validator.isValid(notificationSealsContainers, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnTrueIfTheSealNumberHasAValue() {
    // When
    boolean result = validator.isValid(notificationSealsContainers, null);

    // Then
    assertTrue(result);
  }
}
