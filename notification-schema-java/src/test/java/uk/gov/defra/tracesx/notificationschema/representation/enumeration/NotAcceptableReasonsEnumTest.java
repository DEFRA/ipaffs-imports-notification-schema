package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class NotAcceptableReasonsEnumTest {
  private final static String ID_HEALTH_MARK_ERROR = "IdHealthMarkError";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = NotAcceptableReasonsEnum.IDHEALTHMARKERROR.toString();

    assertThat(enumResult).isEqualTo(ID_HEALTH_MARK_ERROR);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = NotAcceptableReasonsEnum.IDHEALTHMARKERROR.getValue();

    assertThat(enumResult).isEqualTo(ID_HEALTH_MARK_ERROR);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    NotAcceptableReasonsEnum enumResult = NotAcceptableReasonsEnum.fromValue(ID_HEALTH_MARK_ERROR);

    assertThat(enumResult).isEqualTo(NotAcceptableReasonsEnum.IDHEALTHMARKERROR);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    NotAcceptableReasonsEnum enumResult = NotAcceptableReasonsEnum.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
