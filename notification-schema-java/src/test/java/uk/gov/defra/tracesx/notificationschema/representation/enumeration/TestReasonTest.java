package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class TestReasonTest {
  private final static String RANDOM_STRING = "Random";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = TestReason.RANDOM.toString();

    assertEquals(enumResult, RANDOM_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = TestReason.RANDOM.getValue();

    assertEquals(enumResult, RANDOM_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    TestReason enumResult = TestReason.fromValue(RANDOM_STRING);

    assertEquals(enumResult, TestReason.RANDOM);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    TestReason enumResult = TestReason.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
