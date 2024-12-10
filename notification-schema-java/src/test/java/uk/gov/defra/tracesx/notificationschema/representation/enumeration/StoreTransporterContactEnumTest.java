package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StoreTransporterContactEnumTest {

  @Test
  void givenYesValue_whenValueOfCalled_shouldReturnEnumValue() {
    assertThat(StoreTransporterContactEnum.valueOf("YES")).isEqualTo(StoreTransporterContactEnum.YES);
  }

  @Test
  void givenNoValue_whenValueOfCalled_shouldReturnEnumValue() {
    assertThat(StoreTransporterContactEnum.valueOf("NO")).isEqualTo(StoreTransporterContactEnum.NO);
  }
}
