package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class ForNonConformingEnumTest {
  private final static String CUSTOMS_WAREHOUSE_STRING = "Customs Warehouse";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ForNonConformingEnum.CUSTOMS_WAREHOUSE.toString();

    assertEquals(enumResult, CUSTOMS_WAREHOUSE_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ForNonConformingEnum.CUSTOMS_WAREHOUSE.getValue();

    assertEquals(enumResult, CUSTOMS_WAREHOUSE_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    ForNonConformingEnum enumResult = ForNonConformingEnum.fromValue(CUSTOMS_WAREHOUSE_STRING);

    assertEquals(enumResult, ForNonConformingEnum.CUSTOMS_WAREHOUSE);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    ForNonConformingEnum enumResult = ForNonConformingEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
