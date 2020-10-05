package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class ExternalSystemTest {
  private final static String TRACESNT_STRING = "TRACESNT";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ExternalSystem.TRACESNT.toString();

    assertEquals(enumResult, TRACESNT_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ExternalSystem.TRACESNT.getValue();

    assertEquals(enumResult, TRACESNT_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    ExternalSystem enumResult = ExternalSystem.fromValue(TRACESNT_STRING);

    assertEquals(enumResult, ExternalSystem.TRACESNT);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    ExternalSystem enumResult = ExternalSystem.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
