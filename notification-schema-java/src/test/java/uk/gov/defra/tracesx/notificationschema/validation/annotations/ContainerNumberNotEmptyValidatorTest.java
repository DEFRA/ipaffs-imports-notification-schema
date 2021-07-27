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
public class ContainerNumberNotEmptyValidatorTest {

  private ContainerNumberNotEmptyValidator validator;

  private List<NotificationSealsContainers> notificationSealsContainers;

  @Before
  public void setUp() {
    validator = new ContainerNumberNotEmptyValidator();
    NotificationSealsContainers container = new NotificationSealsContainers();
    container.setContainerNumber("valid seal number");
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
  public void validatorShouldReturnFalseIfContainerNumberIsNull() {
    // Given
    notificationSealsContainers.get(0).setContainerNumber(null);

    // When
    boolean result = validator.isValid(notificationSealsContainers, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnFalseIfContainerNumberIsEmpty() {
    // Given
    notificationSealsContainers.get(0).setContainerNumber("");


    // When
    boolean result = validator.isValid(notificationSealsContainers, null);

    // Then
    assertFalse(result);
  }

  @Test
  public void validatorShouldReturnTrueIfTheContainerNumberHasAValue() {
    // When
    boolean result = validator.isValid(notificationSealsContainers, null);

    // Then
    assertTrue(result);
  }
}
