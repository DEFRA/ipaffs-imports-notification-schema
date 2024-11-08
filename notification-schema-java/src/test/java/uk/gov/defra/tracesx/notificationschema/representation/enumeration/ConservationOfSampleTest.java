package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ConservationOfSampleTest {
  private final static String CHILLED_STRING = "Chilled";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ConservationOfSample.CHILLED.toString();

    assertThat(enumResult).isEqualTo(CHILLED_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ConservationOfSample.CHILLED.getValue();

    assertThat(enumResult).isEqualTo(CHILLED_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    ConservationOfSample enumResult = ConservationOfSample.fromValue(CHILLED_STRING);

    assertThat(enumResult).isEqualTo(ConservationOfSample.CHILLED);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    ConservationOfSample enumResult = ConservationOfSample.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
