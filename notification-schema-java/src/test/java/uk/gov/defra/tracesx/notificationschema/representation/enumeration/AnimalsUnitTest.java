package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class AnimalsUnitTest {
  private final static String PERCENT_STRING = "percent";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = AnimalsUnit.PERCENT.toString();

    assertEquals(enumResult, PERCENT_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = AnimalsUnit.PERCENT.getValue();

    assertEquals(enumResult, PERCENT_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    AnimalsUnit enumResult = AnimalsUnit.fromValue(PERCENT_STRING);

    assertEquals(enumResult, AnimalsUnit.PERCENT);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    AnimalsUnit enumResult = AnimalsUnit.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
