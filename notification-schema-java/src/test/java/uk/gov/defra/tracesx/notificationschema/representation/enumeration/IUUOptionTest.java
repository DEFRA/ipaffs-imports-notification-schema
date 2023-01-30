package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class IUUOptionTest {
  private final static String IUUNA_STRING = "IUUNA";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    IUUOption enumResult = IUUOption.fromValue(IUUNA_STRING);

    assertEquals(enumResult, IUUOption.IUUNA);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    IUUOption enumResult = IUUOption.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
