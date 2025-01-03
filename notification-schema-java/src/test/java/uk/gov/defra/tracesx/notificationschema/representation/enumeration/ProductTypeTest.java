package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ProductTypeTest {

  private final static String INVALID_STRING = "Invalid";
  private final static String INTENDED_FOR_PLANTING_ALREADY_PLANTED = "Intended for planting: already planted";

  @Test
  void givenAValidEnumValue_ReturnStringValue_WhenToStringCalled() {
    String enumResult = ProductType.INTENDED_FOR_PLANTING_ALREADY_PLANTED.toString();

    assertThat(enumResult).isEqualTo(INTENDED_FOR_PLANTING_ALREADY_PLANTED);
  }

  @Test
  void givenAValidEnumValue_ReturnValue_WhenGetValueCalled() {
    String enumResult = ProductType.INTENDED_FOR_PLANTING_ALREADY_PLANTED.getValue();

    assertThat(enumResult).isEqualTo(INTENDED_FOR_PLANTING_ALREADY_PLANTED);
  }

  @Test
  void givenAValidValue_ReturnEnumValue_WhenFromValueCalled() {
    ProductType enumResult = ProductType.fromValue(INTENDED_FOR_PLANTING_ALREADY_PLANTED);

    assertThat(enumResult).isEqualTo(ProductType.INTENDED_FOR_PLANTING_ALREADY_PLANTED);
  }

  @Test
  void givenAnInvalidValue_ReturnNull_WhenFromValueCalled() {
    ProductType enumResult = ProductType.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
