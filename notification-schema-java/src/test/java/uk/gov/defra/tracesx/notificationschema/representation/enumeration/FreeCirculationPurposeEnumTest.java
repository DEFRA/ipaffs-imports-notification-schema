package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class FreeCirculationPurposeEnumTest {
  private final static String FURTHER_PROCESS_STRING = "Further Process";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = FreeCirculationPurposeEnum.FURTHER_PROCESS.toString();

    assertThat(enumResult).isEqualTo(FURTHER_PROCESS_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = FreeCirculationPurposeEnum.FURTHER_PROCESS.getValue();

    assertThat(enumResult).isEqualTo(FURTHER_PROCESS_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    FreeCirculationPurposeEnum enumResult = FreeCirculationPurposeEnum.fromValue(FURTHER_PROCESS_STRING);

    assertThat(enumResult).isEqualTo(FreeCirculationPurposeEnum.FURTHER_PROCESS);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    FreeCirculationPurposeEnum enumResult = FreeCirculationPurposeEnum.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
