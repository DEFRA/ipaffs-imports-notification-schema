package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class TransportTypeTest {
  private final static String OTHER_STRING = "other";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = TransportType.OTHER.toString();

    assertEquals(enumResult, OTHER_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = TransportType.OTHER.getValue();

    assertEquals(enumResult, OTHER_STRING);
  }
}