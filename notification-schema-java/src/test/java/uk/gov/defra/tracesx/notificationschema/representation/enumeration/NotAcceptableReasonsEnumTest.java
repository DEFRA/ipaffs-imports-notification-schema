package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class NotAcceptableReasonsEnumTest {
  private final static String ID_HEALTH_MARK_ERROR = "IdHealthMarkError";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    NotAcceptableReasonsEnum enumResult = NotAcceptableReasonsEnum.fromValue(ID_HEALTH_MARK_ERROR);

    assertEquals(enumResult, NotAcceptableReasonsEnum.IDHEALTHMARKERROR);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    NotAcceptableReasonsEnum enumResult = NotAcceptableReasonsEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
