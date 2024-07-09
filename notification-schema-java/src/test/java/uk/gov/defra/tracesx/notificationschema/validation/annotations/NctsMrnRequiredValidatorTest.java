package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ExternalReference;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ExternalSystem;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ProvideCtcMrnEnum;

public class NctsMrnRequiredValidatorTest {

  private final NctsMrnRequiredValidator underTest = new NctsMrnRequiredValidator();

  private Notification notification;

  @Before
  public void setup() {
    notification = Notification.builder()
        .externalReferences(
            List.of(
                ExternalReference.builder().system(ExternalSystem.NCTS).reference("mrn").build())
        )
        .partOne(PartOne.builder().provideCtcMrn(ProvideCtcMrnEnum.YES).build())
        .build();
  }

  @Test
  public void isValid_returnsTrue_whenPartOneNull() {
    notification.setPartOne(null);

    assertThat(underTest.isValid(notification, null)).isTrue();
  }

  @Test
  public void isValid_returnsTrue_whenProvideCtcMrnNull() {
    notification.getPartOne().setProvideCtcMrn(null);

    assertThat(underTest.isValid(notification, null)).isTrue();
  }

  @Test
  public void isValid_returnsTrue_whenExternalReferencesNull() {
    notification.setExternalReferences(null);

    assertThat(underTest.isValid(notification, null)).isTrue();
  }

  @Test
  public void isValid_returnsFalse_whenProvideCtcMrnYesAndExternalReferencesDoesNotContainMRN() {
    notification.getPartOne().setProvideCtcMrn(ProvideCtcMrnEnum.YES);
    notification.setExternalReferences(List.of(
        ExternalReference.builder().system(ExternalSystem.ECERT).reference("some-ref").build()));

    assertThat(underTest.isValid(notification, null)).isFalse();
  }

  @Test
  public void isValid_returnsTrue_whenProvideCtcMrnNo() {
    notification.getPartOne().setProvideCtcMrn(ProvideCtcMrnEnum.NO);

    assertThat(underTest.isValid(notification, null)).isTrue();
  }

  @Test
  public void isValid_returnsTrue_whenProvideCtcMrnYesAndExternalReferencesContainsMRN() {
    assertThat(underTest.isValid(notification, null)).isTrue();
  }
}