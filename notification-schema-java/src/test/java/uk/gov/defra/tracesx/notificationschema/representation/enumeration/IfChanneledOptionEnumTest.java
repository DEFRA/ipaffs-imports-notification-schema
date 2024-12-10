package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IfChanneledOptionEnumTest {
  private final static String ARTICLE_8_STRING = "article8";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = IfChanneledOptionEnum.ARTICLE8.toString();

    assertThat(enumResult).isEqualTo(ARTICLE_8_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = IfChanneledOptionEnum.ARTICLE8.getValue();

    assertThat(enumResult).isEqualTo(ARTICLE_8_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    IfChanneledOptionEnum enumResult = IfChanneledOptionEnum.fromValue(ARTICLE_8_STRING);

    assertThat(enumResult).isEqualTo(IfChanneledOptionEnum.ARTICLE8);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    IfChanneledOptionEnum enumResult = IfChanneledOptionEnum.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
