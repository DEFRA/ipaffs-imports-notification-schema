package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class AuthorityTypeTest {
  private final static String EXIT_BIP_STRING = "exitbip";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    AuthorityType enumResult = AuthorityType.fromValue(EXIT_BIP_STRING);

    assertEquals(enumResult, AuthorityType.EXITBIP);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    AuthorityType enumResult = AuthorityType.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
