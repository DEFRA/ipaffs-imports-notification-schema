package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AnalysisTypeTest {
  private final static String INITIAL_ANALYSIS_STRING = "Initial analysis";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = AnalysisType.INITIAL.toString();

    assertThat(enumResult).isEqualTo(INITIAL_ANALYSIS_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = AnalysisType.INITIAL.getValue();

    assertThat(enumResult).isEqualTo(INITIAL_ANALYSIS_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    AnalysisType enumResult = AnalysisType.fromValue(INITIAL_ANALYSIS_STRING);

    assertThat(enumResult).isEqualTo(AnalysisType.INITIAL);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    AnalysisType enumResult = AnalysisType.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
