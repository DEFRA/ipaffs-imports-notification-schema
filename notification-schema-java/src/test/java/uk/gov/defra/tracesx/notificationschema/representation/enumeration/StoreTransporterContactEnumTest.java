package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class StoreTransporterContactEnumTest {

  @Test
  public void givenYesValue_whenValueOfCalled_shouldReturnEnumValue() {
    assertThat(StoreTransporterContactEnum.valueOf("YES")).isEqualTo(StoreTransporterContactEnum.YES);
  }

  @Test
  public void givenNoValue_whenValueOfCalled_shouldReturnEnumValue() {
    assertThat(StoreTransporterContactEnum.valueOf("NO")).isEqualTo(StoreTransporterContactEnum.NO);
  }
}
