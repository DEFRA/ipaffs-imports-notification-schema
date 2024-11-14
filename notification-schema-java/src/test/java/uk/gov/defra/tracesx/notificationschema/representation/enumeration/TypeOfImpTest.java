package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class TypeOfImpTest {
  private final static String LIVE_ANIMALS_STRING = "A";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = TypeOfImp.LIVE_ANIMALS.toString();

    assertThat(enumResult).isEqualTo(LIVE_ANIMALS_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = TypeOfImp.LIVE_ANIMALS.getValue();

    assertThat(enumResult).isEqualTo(LIVE_ANIMALS_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    TypeOfImp enumResult = TypeOfImp.fromValue(LIVE_ANIMALS_STRING);

    assertThat(enumResult).isEqualTo(TypeOfImp.LIVE_ANIMALS);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    TypeOfImp enumResult = TypeOfImp.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
