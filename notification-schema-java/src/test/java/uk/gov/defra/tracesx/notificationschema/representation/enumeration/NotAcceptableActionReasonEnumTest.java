package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class NotAcceptableActionReasonEnumTest {

  private final static String OTHER_STRING = "Other";

  @Test
  public void notAcceptableActionReasonEnumShouldReturnValueWhenValueIsValid() {
    NotAcceptableActionReasonEnum enumResult = NotAcceptableActionReasonEnum
        .fromValue(OTHER_STRING);

    assertEquals(enumResult, NotAcceptableActionReasonEnum.OTHER);
    assertNotNull(enumResult);
  }

  @Test
  public void notAcceptableActionReasonEnumShouldReturnNullWhenValueIsInvalid() {
    NotAcceptableActionReasonEnum enumResult = NotAcceptableActionReasonEnum
        .fromValue("invalid");

    assertNull(enumResult);
  }

  @Test
  public void notAcceptableActionReasonShouldReturnStringValue() {
    String enumResult = NotAcceptableActionReasonEnum.OTHER.toString();

    assertEquals(OTHER_STRING, enumResult);
  }
}


