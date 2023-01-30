package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class ConservationOfSampleTest {
  private final static String CHILLED_STRING = "Chilled";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    ConservationOfSample enumResult = ConservationOfSample.fromValue(CHILLED_STRING);

    assertEquals(enumResult, ConservationOfSample.CHILLED);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    ConservationOfSample enumResult = ConservationOfSample.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
