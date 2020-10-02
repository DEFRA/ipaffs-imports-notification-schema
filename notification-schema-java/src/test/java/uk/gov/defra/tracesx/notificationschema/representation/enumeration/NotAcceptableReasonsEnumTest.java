package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class NotAcceptableReasonsEnumTest {
  private final static String ID_HEALTH_MARK_ERROR = "IdHealthMarkError";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = NotAcceptableReasonsEnum.IDHEALTHMARKERROR.toString();

    assertEquals(enumResult, ID_HEALTH_MARK_ERROR);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = NotAcceptableReasonsEnum.IDHEALTHMARKERROR.getValue();

    assertEquals(enumResult, ID_HEALTH_MARK_ERROR);
  }
}