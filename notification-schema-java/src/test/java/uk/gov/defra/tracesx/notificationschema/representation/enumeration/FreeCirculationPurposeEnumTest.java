package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class FreeCirculationPurposeEnumTest {
  private final static String FURTHER_PROCESS_STRING = "Further Process";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    FreeCirculationPurposeEnum enumResult = FreeCirculationPurposeEnum.fromValue(FURTHER_PROCESS_STRING);

    assertEquals(enumResult, FreeCirculationPurposeEnum.FURTHER_PROCESS);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    FreeCirculationPurposeEnum enumResult = FreeCirculationPurposeEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
