package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class IUUOptionTest {
  private final static String IUUNA_STRING = "IUUNA";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = IUUOption.IUUNA.toString();

    assertThat(enumResult).isEqualTo(IUUNA_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = IUUOption.IUUNA.getValue();

    assertThat(enumResult).isEqualTo(IUUNA_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    IUUOption enumResult = IUUOption.fromValue(IUUNA_STRING);

    assertThat(enumResult).isEqualTo(IUUOption.IUUNA);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    IUUOption enumResult = IUUOption.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
