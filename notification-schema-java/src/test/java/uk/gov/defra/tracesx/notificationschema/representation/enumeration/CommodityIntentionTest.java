package uk.gov.defra.tracesx.notificationschema.representation.enumeration;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CommodityIntentionTest {
  private final static String HUMAN_STRING = "human";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = CommodityIntention.HUMAN.toString();

    assertThat(enumResult).isEqualTo(HUMAN_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = CommodityIntention.HUMAN.getValue();

    assertThat(enumResult).isEqualTo(HUMAN_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    CommodityIntention enumResult = CommodityIntention.fromValue(HUMAN_STRING);

    assertThat(enumResult).isEqualTo(CommodityIntention.HUMAN);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    CommodityIntention enumResult = CommodityIntention.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
