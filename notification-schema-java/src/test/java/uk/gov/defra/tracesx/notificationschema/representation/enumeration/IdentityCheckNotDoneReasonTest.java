package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class IdentityCheckNotDoneReasonTest {

  private final static String REDUCED_CHECKS_REGIME_STRING = "Reduced checks regime";
  private final static String NOT_REQUIRED_STRING = "Not required";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = IdentityCheckNotDoneReason.REDUCED_CHECKS_REGIME.toString();

    assertEquals(enumResult, REDUCED_CHECKS_REGIME_STRING);
  }

  @Test
  public void givenAValidEnumValue_notRequired_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = IdentityCheckNotDoneReason.NOT_REQUIRED.toString();

    assertEquals(enumResult, NOT_REQUIRED_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = IdentityCheckNotDoneReason.NOT_REQUIRED.getValue();

    assertEquals(enumResult, NOT_REQUIRED_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    IdentityCheckNotDoneReason enumResult = IdentityCheckNotDoneReason.fromValue(
        NOT_REQUIRED_STRING);

    assertEquals(enumResult, IdentityCheckNotDoneReason.NOT_REQUIRED);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    IdentityCheckNotDoneReason enumResult = IdentityCheckNotDoneReason.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
