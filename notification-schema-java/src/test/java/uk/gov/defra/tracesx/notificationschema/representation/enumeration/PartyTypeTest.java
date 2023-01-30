package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class PartyTypeTest {
  private final static String COMMERCIAL_TRANSPORTER_STRING = "Commercial transporter";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    PartyType enumResult = PartyType.fromValue(COMMERCIAL_TRANSPORTER_STRING);

    assertEquals(enumResult, PartyType.COMMERCIAL_TRANSPORTER);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    PartyType enumResult = PartyType.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
