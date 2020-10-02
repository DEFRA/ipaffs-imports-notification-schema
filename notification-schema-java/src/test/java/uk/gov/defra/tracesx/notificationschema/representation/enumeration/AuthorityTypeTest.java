package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class AuthorityTypeTest {
  private final static String EXIT_BIP_STRING = "exitbip";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = AuthorityType.EXITBIP.toString();

    assertEquals(enumResult, EXIT_BIP_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = AuthorityType.EXITBIP.getValue();

    assertEquals(enumResult, EXIT_BIP_STRING);
  }
}