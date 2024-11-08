package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

 class AnimalsUnitTest {
  private final static String PERCENT_STRING = "percent";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = AnimalsUnit.PERCENT.toString();

    assertThat(enumResult).isEqualTo(PERCENT_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = AnimalsUnit.PERCENT.getValue();

    assertThat(enumResult).isEqualTo(PERCENT_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    AnimalsUnit enumResult = AnimalsUnit.fromValue(PERCENT_STRING);

    assertThat(enumResult).isEqualTo(AnimalsUnit.PERCENT);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    AnimalsUnit enumResult = AnimalsUnit.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
