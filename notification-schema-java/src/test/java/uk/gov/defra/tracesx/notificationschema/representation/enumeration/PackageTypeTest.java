package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class PackageTypeTest {
  private final static String BAG_STRING = "Bag";
  private final static String INVALID_STRING = "Invalid";
  private final static String LEGACY_BULK = "Bulk";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = PackageType.BAG.toString();

    assertEquals(enumResult, BAG_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = PackageType.BAG.getValue();

    assertEquals(enumResult, BAG_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    PackageType enumResult = PackageType.fromValue(BAG_STRING);

    assertEquals(enumResult, PackageType.BAG);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    PackageType enumResult = PackageType.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }

  @Test
  public void fromValue_whenCalledWithLegacyBulk_shouldReturnEnumValueOfLegacyBulk() {
    PackageType enumResult = PackageType.fromValue(LEGACY_BULK);

    assertEquals(enumResult, PackageType.LEGACY_BULK);
  }
}
