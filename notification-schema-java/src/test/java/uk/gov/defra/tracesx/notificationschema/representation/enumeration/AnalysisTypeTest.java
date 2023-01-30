package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class AnalysisTypeTest {
  private final static String INITIAL_ANALYSIS_STRING = "Initial analysis";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    AnalysisType enumResult = AnalysisType.fromValue(INITIAL_ANALYSIS_STRING);

    assertEquals(enumResult, AnalysisType.INITIAL);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    AnalysisType enumResult = AnalysisType.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
