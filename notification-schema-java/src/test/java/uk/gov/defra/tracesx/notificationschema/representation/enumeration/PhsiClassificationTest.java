package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PhsiClassificationTest {
  private final static String MANDATORY_STRING = "Mandatory";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = PhsiClassification.MANDATORY.toString();

    assertThat(enumResult).isEqualTo(MANDATORY_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = PhsiClassification.MANDATORY.getValue();

    assertThat(enumResult).isEqualTo(MANDATORY_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    PhsiClassification enumResult = PhsiClassification.fromValue(MANDATORY_STRING);

    assertThat(enumResult).isEqualTo(PhsiClassification.MANDATORY);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    PhsiDecision enumResult = PhsiDecision.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
