package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TransportTypeTest {
  private final static String OTHER_STRING = "other";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = TransportType.OTHER.toString();

    assertThat(enumResult).isEqualTo(OTHER_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = TransportType.OTHER.getValue();

    assertThat(enumResult).isEqualTo(OTHER_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    TransportType enumResult = TransportType.fromValue(OTHER_STRING);

    assertThat(enumResult).isEqualTo(TransportType.OTHER);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    TransportType enumResult = TransportType.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
