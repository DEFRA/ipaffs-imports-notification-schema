package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ImpQuantityDataKeysTest {
  private final static String QUANTITY_STRING = "quantity";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ImpQuantityDataKeys.QUANTITY.toString();

    assertThat(enumResult).isEqualTo(QUANTITY_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ImpQuantityDataKeys.QUANTITY.getValue();

    assertThat(enumResult).isEqualTo(QUANTITY_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    ImpQuantityDataKeys enumResult = ImpQuantityDataKeys.fromValue(QUANTITY_STRING);

    assertThat(enumResult).isEqualTo(ImpQuantityDataKeys.QUANTITY);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    ImpQuantityDataKeys enumResult = ImpQuantityDataKeys.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
