package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ConclusionTest {
  private final static String SATISFACTORY_STRING = "Satisfactory";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = Conclusion.SATISFACTORY.toString();

    assertEquals(enumResult, SATISFACTORY_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = Conclusion.SATISFACTORY.getValue();

    assertEquals(enumResult, SATISFACTORY_STRING);
  }
}
