package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NotAcceptableActionEnumTest {
  private final static String DESTRUCTION_STRING = "destruction";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = NotAcceptableActionEnum.DESTRUCTION.toString();

    assertThat(enumResult).isEqualTo(DESTRUCTION_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = NotAcceptableActionEnum.DESTRUCTION.getValue();

    assertThat(enumResult).isEqualTo(DESTRUCTION_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    NotAcceptableActionEnum enumResult = NotAcceptableActionEnum.fromValue(DESTRUCTION_STRING);

    assertThat(enumResult).isEqualTo(NotAcceptableActionEnum.DESTRUCTION);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    NotAcceptableActionEnum enumResult = NotAcceptableActionEnum.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
