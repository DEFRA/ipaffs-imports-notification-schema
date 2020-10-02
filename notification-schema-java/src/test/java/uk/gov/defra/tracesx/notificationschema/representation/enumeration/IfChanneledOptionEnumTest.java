package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class IfChanneledOptionEnumTest {
  private final static String ARTICLE_8_STRING = "article8";

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
}