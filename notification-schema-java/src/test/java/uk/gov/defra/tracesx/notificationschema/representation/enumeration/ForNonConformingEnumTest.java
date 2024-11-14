package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ForNonConformingEnumTest {
  private final static String CUSTOMS_WAREHOUSE_STRING = "Customs Warehouse";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ForNonConformingEnum.CUSTOMS_WAREHOUSE.toString();

    assertThat(enumResult).isEqualTo(CUSTOMS_WAREHOUSE_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ForNonConformingEnum.CUSTOMS_WAREHOUSE.getValue();

    assertThat(enumResult).isEqualTo(CUSTOMS_WAREHOUSE_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    ForNonConformingEnum enumResult = ForNonConformingEnum.fromValue(CUSTOMS_WAREHOUSE_STRING);

    assertThat(enumResult).isEqualTo(ForNonConformingEnum.CUSTOMS_WAREHOUSE);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    ForNonConformingEnum enumResult = ForNonConformingEnum.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
