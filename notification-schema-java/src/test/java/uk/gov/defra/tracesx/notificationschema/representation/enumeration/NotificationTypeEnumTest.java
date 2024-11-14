package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NotificationTypeEnumTest {
  private final static String CED_STRING = "CED";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = NotificationTypeEnum.CED.toString();

    assertThat(enumResult).isEqualTo(CED_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = NotificationTypeEnum.CED.getValue();

    assertThat(enumResult).isEqualTo(CED_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    NotificationTypeEnum enumResult = NotificationTypeEnum.fromValue(CED_STRING);

    assertThat(enumResult).isEqualTo(NotificationTypeEnum.CED);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    NotificationTypeEnum enumResult = NotificationTypeEnum.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
