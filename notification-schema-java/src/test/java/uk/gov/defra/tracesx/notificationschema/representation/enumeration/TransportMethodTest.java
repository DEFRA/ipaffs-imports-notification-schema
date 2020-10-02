package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class TransportMethodTest {
  private final static String OTHER_STRING = "Other";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = TransportMethod.OTHER.toString();

    assertEquals(enumResult, OTHER_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = TransportMethod.OTHER.getValue();

    assertEquals(enumResult, OTHER_STRING);
  }
}