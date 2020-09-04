package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class IdentificationCheckTypeTest {
  private final static String SEAL_CHECK_STRING = "Seal Check";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = IdentificationCheckType.SEAL_CHECK.toString();

    assertEquals(enumResult, SEAL_CHECK_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = IdentificationCheckType.SEAL_CHECK.getValue();

    assertEquals(enumResult, SEAL_CHECK_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    IdentificationCheckType enumResult = IdentificationCheckType.fromValue(SEAL_CHECK_STRING);

    assertEquals(enumResult, IdentificationCheckType.SEAL_CHECK);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    IdentificationCheckType enumResult = IdentificationCheckType.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
