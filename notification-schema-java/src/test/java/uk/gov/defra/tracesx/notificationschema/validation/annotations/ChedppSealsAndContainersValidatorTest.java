package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.NotificationSealsContainers;

public class ChedppSealsAndContainersValidatorTest {

  private ChedppSealsAndContainersValidator validator;

  @Before
  public void setup() {
    validator = new ChedppSealsAndContainersValidator();
  }

  @Test
  public void isValid_ReturnsTrue_WhenNotificationSealHasContainerNumberAndSealNumber() {
    NotificationSealsContainers containers = new NotificationSealsContainers("s1", "c1", false, "");
    assertThat(validator.isValid(containers, null)).isTrue();
  }

  @Test
  public void isValid_ReturnsTrue_WhenNotificationSealHasContainerNumber() {
    NotificationSealsContainers containers = new NotificationSealsContainers(null, "c1", false, "");
    assertThat(validator.isValid(containers, null)).isTrue();
  }

  @Test
  public void isValid_ReturnsTrue_WhenNotificationSealHasSealNumber() {
    NotificationSealsContainers containers = new NotificationSealsContainers("s1", null, false, "");
    assertThat(validator.isValid(containers, null)).isTrue();
  }

  @Test
  public void isValid_ReturnsTrue_WhenNotificationSealsContainersIsNull() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  public void isValid_ReturnsFalse_WhenNotificationDoesNotHaveAContainerNumberOrSealNumber() {
    NotificationSealsContainers containers = new NotificationSealsContainers(null, null, false, "");
    assertThat(validator.isValid(containers, null)).isFalse();
  }
}
