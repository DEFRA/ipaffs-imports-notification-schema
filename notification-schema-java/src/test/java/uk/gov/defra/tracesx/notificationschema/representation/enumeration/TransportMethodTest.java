package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class TransportMethodTest {
  private final static String OTHER_STRING = "Other";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    TransportMethod enumResult = TransportMethod.fromValue(OTHER_STRING);

    assertEquals(enumResult, TransportMethod.OTHER);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    TransportMethod enumResult = TransportMethod.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
