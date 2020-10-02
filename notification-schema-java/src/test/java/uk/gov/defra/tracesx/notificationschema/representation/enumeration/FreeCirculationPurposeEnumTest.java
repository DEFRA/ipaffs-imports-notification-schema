package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class FreeCirculationPurposeEnumTest {
  private final static String FURTHER_PROCESS_STRING = "Further Process";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = FreeCirculationPurposeEnum.FURTHER_PROCESS.toString();

    assertEquals(enumResult, FURTHER_PROCESS_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = FreeCirculationPurposeEnum.FURTHER_PROCESS.getValue();

    assertEquals(enumResult, FURTHER_PROCESS_STRING);
  }
}