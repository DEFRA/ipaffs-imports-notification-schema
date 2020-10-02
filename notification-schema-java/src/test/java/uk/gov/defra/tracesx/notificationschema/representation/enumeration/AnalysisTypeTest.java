package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class AnalysisTypeTest {
  private final static String INITIAL_ANALYSIS_STRING = "Initial analysis";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = AnalysisType.INITIAL.toString();

    assertEquals(enumResult, INITIAL_ANALYSIS_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = AnalysisType.INITIAL.getValue();

    assertEquals(enumResult, INITIAL_ANALYSIS_STRING);
  }
}
