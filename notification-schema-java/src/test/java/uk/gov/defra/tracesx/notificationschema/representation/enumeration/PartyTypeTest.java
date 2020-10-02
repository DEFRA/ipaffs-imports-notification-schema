package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class PartyTypeTest {
  private final static String COMMERCIAL_TRANSPORTER_STRING = "Commercial transporter";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = PartyType.COMMERCIAL_TRANSPORTER.toString();

    assertEquals(enumResult, COMMERCIAL_TRANSPORTER_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = PartyType.COMMERCIAL_TRANSPORTER.getValue();

    assertEquals(enumResult, COMMERCIAL_TRANSPORTER_STRING);
  }
}