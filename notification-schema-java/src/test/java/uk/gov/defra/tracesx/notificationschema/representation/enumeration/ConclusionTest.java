package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class ConclusionTest {
  private final static String SATISFACTORY_STRING = "Satisfactory";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    Conclusion enumResult = Conclusion.fromValue(SATISFACTORY_STRING);

    assertEquals(enumResult, Conclusion.SATISFACTORY);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    Conclusion enumResult = Conclusion.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
