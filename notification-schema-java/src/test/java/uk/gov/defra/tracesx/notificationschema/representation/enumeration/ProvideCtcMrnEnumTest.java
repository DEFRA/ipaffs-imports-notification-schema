package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ProvideCtcMrnEnumTest {
  @Test
  public void givenYesAddLaterValue_whenValueOfCalled_shouldReturnEnumValue() {
    assertThat(ProvideCtcMrnEnum.valueOf("YES_ADD_LATER")).isEqualTo(ProvideCtcMrnEnum.YES_ADD_LATER);
  }

  @Test
  public void givenYesValue_whenValueOfCalled_shouldReturnEnumValue() {
    assertThat(ProvideCtcMrnEnum.valueOf("YES")).isEqualTo(ProvideCtcMrnEnum.YES);
  }

  @Test
  public void givenNoValue_whenValueOfCalled_shouldReturnEnumValue() {
    assertThat(ProvideCtcMrnEnum.valueOf("NO")).isEqualTo(ProvideCtcMrnEnum.NO);
  }

}
