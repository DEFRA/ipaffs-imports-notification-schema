package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TestReasonTest {
  private final static String RANDOM_STRING = "Random";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = TestReason.RANDOM.toString();

    assertThat(enumResult).isEqualTo(RANDOM_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = TestReason.RANDOM.getValue();

    assertThat(enumResult).isEqualTo(RANDOM_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    TestReason enumResult = TestReason.fromValue(RANDOM_STRING);

    assertThat(enumResult).isEqualTo(TestReason.RANDOM);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    TestReason enumResult = TestReason.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
