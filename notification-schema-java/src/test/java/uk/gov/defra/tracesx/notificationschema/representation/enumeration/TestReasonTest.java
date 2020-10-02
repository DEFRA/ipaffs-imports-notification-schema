package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class TestReasonTest {
  private final static String RANDOM_STRING = "Random";

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
}