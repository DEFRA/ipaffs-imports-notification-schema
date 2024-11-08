package uk.gov.defra.tracesx.notificationschema.representation;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ExternalSystem;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotificationTypeEnum;

class NotificationTest {

  private final Notification notification = new Notification();

  @Test
  void isCveda_ReturnsTrue_whenTypeIsCveda() {
    notification.setType(NotificationTypeEnum.CVEDA);
    assertThat(notification.isCveda()).isTrue();
  }

  @Test
  void isCvedp_ReturnsTrue_whenTypeIsCvedp() {
    notification.setType(NotificationTypeEnum.CVEDP);
    assertThat(notification.isCvedp()).isTrue();
  }

  @Test
  void isCed_ReturnsTrue_whenTypeIsCed() {
    notification.setType(NotificationTypeEnum.CED);
    assertThat(notification.isCed()).isTrue();
  }

  @Test
  void isChedpp_ReturnsTrue_whenTypeIsChedpp() {
    notification.setType(NotificationTypeEnum.CHEDPP);
    assertThat(notification.isChedpp()).isTrue();
  }

  @Test
  void isClonedChedP_ReturnsTrue_whenTypeIsChedpAndCloned() {
    notification.setType(NotificationTypeEnum.CVEDP);
    notification.setExternalReferences(List.of(ExternalReference.builder().system(ExternalSystem.ECERT).build()));
    assertThat(notification.isClonedChedP()).isTrue();
  }

  @Test
  void isClonedChedP_ReturnsFalse_whenTypeIsNotChedp() {
    notification.setType(NotificationTypeEnum.CHEDPP);
    notification.setExternalReferences(List.of(ExternalReference.builder().system(ExternalSystem.ECERT).build()));
    assertThat(notification.isClonedChedP()).isFalse();
  }

  @Test
  void isClonedChedP_ReturnsFalse_whenTypeIsChedpAndExternalReferenceIsEPHYTO() {
    notification.setType(NotificationTypeEnum.CVEDP);
    notification.setExternalReferences(List.of(ExternalReference.builder().system(ExternalSystem.EPHYTO).build()));
    assertThat(notification.isClonedChedP()).isFalse();
  }

  @Test
  void isClonedChedP_ReturnsFalse_whenTypeIsChedpNoExternalReference() {
    notification.setType(NotificationTypeEnum.CVEDP);
    assertThat(notification.isClonedChedP()).isFalse();
  }
}
