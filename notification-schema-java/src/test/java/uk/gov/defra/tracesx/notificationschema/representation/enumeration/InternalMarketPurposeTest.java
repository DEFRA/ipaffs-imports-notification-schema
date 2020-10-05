package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class InternalMarketPurposeTest {
  private final static String OTHER_STRING = "Other";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = InternalMarketPurpose.OTHER.toString();

    assertEquals(enumResult, OTHER_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = InternalMarketPurpose.OTHER.getValue();

    assertEquals(enumResult, OTHER_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    InternalMarketPurpose enumResult = InternalMarketPurpose.fromValue(OTHER_STRING);

    assertEquals(enumResult, InternalMarketPurpose.OTHER);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    InternalMarketPurpose enumResult = InternalMarketPurpose.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
