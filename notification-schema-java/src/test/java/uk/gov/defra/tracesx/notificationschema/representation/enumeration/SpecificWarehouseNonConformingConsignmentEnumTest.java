package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SpecificWarehouseNonConformingConsignmentEnumTest {
  private final static String SHIP_STRING = "Ship";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = SpecificWarehouseNonConformingConsignmentEnum.SHIP.toString();

    assertThat(enumResult).isEqualTo(SHIP_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = SpecificWarehouseNonConformingConsignmentEnum.SHIP.getValue();

    assertThat(enumResult).isEqualTo(SHIP_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    SpecificWarehouseNonConformingConsignmentEnum enumResult = SpecificWarehouseNonConformingConsignmentEnum.fromValue(SHIP_STRING);

    assertThat(enumResult).isEqualTo(SpecificWarehouseNonConformingConsignmentEnum.SHIP);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    SpecificWarehouseNonConformingConsignmentEnum enumResult = SpecificWarehouseNonConformingConsignmentEnum.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
