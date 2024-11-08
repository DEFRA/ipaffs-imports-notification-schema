package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ProvideCtcMrnEnumTest {
  @Test
  void givenYesAddLaterValue_whenValueOfCalled_shouldReturnEnumValue() {
    assertThat(ProvideCtcMrnEnum.valueOf("YES_ADD_LATER")).isEqualTo(ProvideCtcMrnEnum.YES_ADD_LATER);
  }

  @Test
  void givenYesValue_whenValueOfCalled_shouldReturnEnumValue() {
    assertThat(ProvideCtcMrnEnum.valueOf("YES")).isEqualTo(ProvideCtcMrnEnum.YES);
  }

  @Test
  void givenNoValue_whenValueOfCalled_shouldReturnEnumValue() {
    assertThat(ProvideCtcMrnEnum.valueOf("NO")).isEqualTo(ProvideCtcMrnEnum.NO);
  }

}
