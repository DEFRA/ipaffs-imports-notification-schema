package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class IdentificationCheckTypeTest {
  private final static String SEAL_CHECK_STRING = "Seal Check";

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
}