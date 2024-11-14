package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PartyTypeTest {
  private final static String COMMERCIAL_TRANSPORTER_STRING = "Commercial transporter";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = PartyType.COMMERCIAL_TRANSPORTER.toString();

    assertThat(enumResult).isEqualTo(COMMERCIAL_TRANSPORTER_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = PartyType.COMMERCIAL_TRANSPORTER.getValue();

    assertThat(enumResult).isEqualTo(COMMERCIAL_TRANSPORTER_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    PartyType enumResult = PartyType.fromValue(COMMERCIAL_TRANSPORTER_STRING);

    assertThat(enumResult).isEqualTo(PartyType.COMMERCIAL_TRANSPORTER);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    PartyType enumResult = PartyType.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
