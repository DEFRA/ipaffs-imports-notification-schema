package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PackageTypeTest {
  private final static String BAG_STRING = "Bag";
  private final static String INVALID_STRING = "Invalid";
  private final static String LEGACY_BULK = "Bulk";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = PackageType.BAG.toString();

    assertThat(enumResult).isEqualTo(BAG_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = PackageType.BAG.getValue();

    assertThat(enumResult).isEqualTo(BAG_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    PackageType enumResult = PackageType.fromValue(BAG_STRING);

    assertThat(enumResult).isEqualTo(PackageType.BAG);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    PackageType enumResult = PackageType.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }

  @Test
  void fromValue_whenCalledWithLegacyBulk_shouldReturnEnumValueOfLegacyBulk() {
    PackageType enumResult = PackageType.fromValue(LEGACY_BULK);

    assertThat(enumResult).isEqualTo(PackageType.LEGACY_BULK);
  }
}
