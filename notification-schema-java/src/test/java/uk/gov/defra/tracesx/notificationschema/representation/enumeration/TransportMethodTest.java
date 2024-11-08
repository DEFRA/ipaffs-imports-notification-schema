package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TransportMethodTest {
  private final static String OTHER_STRING = "Other";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = TransportMethod.OTHER.toString();

    assertThat(enumResult).isEqualTo(OTHER_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = TransportMethod.OTHER.getValue();

    assertThat(enumResult).isEqualTo(OTHER_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    TransportMethod enumResult = TransportMethod.fromValue(OTHER_STRING);

    assertThat(enumResult).isEqualTo(TransportMethod.OTHER);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    TransportMethod enumResult = TransportMethod.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
