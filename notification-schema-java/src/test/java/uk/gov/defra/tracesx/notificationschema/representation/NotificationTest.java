package uk.gov.defra.tracesx.notificationschema.representation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotificationTypeEnum;

public class NotificationTest {

  private final Notification notification = new Notification();

  @Test
  public void isCveda_ReturnsTrue_whenTypeIsCveda() {
    notification.setType(NotificationTypeEnum.CVEDA);
    assertThat(notification.isCveda()).isTrue();
  }

  @Test
  public void isCvedp_ReturnsTrue_whenTypeIsCvedp() {
    notification.setType(NotificationTypeEnum.CVEDP);
    assertThat(notification.isCvedp()).isTrue();
  }

  @Test
  public void isCed_ReturnsTrue_whenTypeIsCed() {
    notification.setType(NotificationTypeEnum.CED);
    assertThat(notification.isCed()).isTrue();
  }

  @Test
  public void isChedpp_ReturnsTrue_whenTypeIsChedpp() {
    notification.setType(NotificationTypeEnum.CHEDPP);
    assertThat(notification.isChedpp()).isTrue();
  }
}