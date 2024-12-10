package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

 class AnimalCertificationTest {
  private final static String APPROVED_STRING = "Approved";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = AnimalCertification.APPROVED.toString();

    assertThat(enumResult).isEqualTo(APPROVED_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = AnimalCertification.APPROVED.getValue();

    assertThat(enumResult).isEqualTo(APPROVED_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    AnimalCertification enumResult = AnimalCertification.fromValue(APPROVED_STRING);

    assertThat(enumResult).isEqualTo(AnimalCertification.APPROVED);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    AnimalCertification enumResult = AnimalCertification.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
