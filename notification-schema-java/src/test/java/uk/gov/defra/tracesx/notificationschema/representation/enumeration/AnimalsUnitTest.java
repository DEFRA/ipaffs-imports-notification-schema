package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class AnimalsUnitTest {
  private final static String PERCENT_STRING = "percent";

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
}