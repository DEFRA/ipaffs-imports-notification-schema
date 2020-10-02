package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class IUUOptionTest {
  private final static String IUUNA_STRING = "IUUNA";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = IUUOption.IUUNA.toString();

    assertEquals(enumResult, IUUNA_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = IUUOption.IUUNA.getValue();

    assertEquals(enumResult, IUUNA_STRING);
  }
}