package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class IfChanneledOptionEnumTest {
  private final static String ARTICLE_8_STRING = "article8";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = IfChanneledOptionEnum.ARTICLE8.toString();

    assertEquals(enumResult, ARTICLE_8_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = IfChanneledOptionEnum.ARTICLE8.getValue();

    assertEquals(enumResult, ARTICLE_8_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    IfChanneledOptionEnum enumResult = IfChanneledOptionEnum.fromValue(ARTICLE_8_STRING);

    assertEquals(enumResult, IfChanneledOptionEnum.ARTICLE8);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    IfChanneledOptionEnum enumResult = IfChanneledOptionEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
