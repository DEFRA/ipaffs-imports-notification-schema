package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NotAcceptableActionReasonEnumTest {
  private final static String OTHER_STRING = "Other";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = NotAcceptableActionReasonEnum.OTHER.toString();

    assertThat(enumResult).isEqualTo(OTHER_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = NotAcceptableActionReasonEnum.OTHER.getValue();

    assertThat(enumResult).isEqualTo(OTHER_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    NotAcceptableActionReasonEnum enumResult = NotAcceptableActionReasonEnum.fromValue(OTHER_STRING);

    assertThat(enumResult).isEqualTo(NotAcceptableActionReasonEnum.OTHER);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    NotAcceptableActionReasonEnum enumResult = NotAcceptableActionReasonEnum.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
