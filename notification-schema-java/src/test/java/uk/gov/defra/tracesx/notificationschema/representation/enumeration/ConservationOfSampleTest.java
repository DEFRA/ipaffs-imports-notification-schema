package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ConservationOfSampleTest {
  private final static String CHILLED_STRING = "Chilled";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ConservationOfSample.CHILLED.toString();

    assertEquals(enumResult, CHILLED_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ConservationOfSample.CHILLED.getValue();

    assertEquals(enumResult, CHILLED_STRING);
  }
}