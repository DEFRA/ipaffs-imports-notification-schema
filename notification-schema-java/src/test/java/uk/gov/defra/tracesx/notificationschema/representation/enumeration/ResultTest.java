package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ResultTest {
  private final static String DEROGATION_STRING = "Derogation";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = Result.DEROGATION.toString();

    assertEquals(enumResult, DEROGATION_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = Result.DEROGATION.getValue();

    assertEquals(enumResult, DEROGATION_STRING);
  }
}