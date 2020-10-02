package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ForNonConformingEnumTest {
  private final static String CUSTOMS_WAREHOUSE_STRING = "Customs Warehouse";

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
}