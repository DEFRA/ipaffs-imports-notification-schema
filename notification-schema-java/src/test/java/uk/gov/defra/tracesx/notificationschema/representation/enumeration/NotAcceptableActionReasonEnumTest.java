package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class NotAcceptableActionReasonEnumTest {
  private final static String OTHER_STRING = "Other";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = NotAcceptableActionReasonEnum.OTHER.toString();

    assertEquals(enumResult, OTHER_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = NotAcceptableActionReasonEnum.OTHER.getValue();

    assertEquals(enumResult, OTHER_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    NotAcceptableActionReasonEnum enumResult = NotAcceptableActionReasonEnum.fromValue(OTHER_STRING);

    assertEquals(enumResult, NotAcceptableActionReasonEnum.OTHER);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    NotAcceptableActionReasonEnum enumResult = NotAcceptableActionReasonEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
