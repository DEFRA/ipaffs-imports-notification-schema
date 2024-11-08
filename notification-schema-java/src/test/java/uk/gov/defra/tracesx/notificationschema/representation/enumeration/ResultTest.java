package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {
  private final static String DEROGATION_STRING = "Derogation";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = Result.DEROGATION.toString();

    assertThat(enumResult).isEqualTo(DEROGATION_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = Result.DEROGATION.getValue();

    assertThat(enumResult).isEqualTo(DEROGATION_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    Result enumResult = Result.fromValue(DEROGATION_STRING);

    assertThat(enumResult).isEqualTo(Result.DEROGATION);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    Result enumResult = Result.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
