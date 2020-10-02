package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class SpecificWarehouseNonConformingConsignmentEnumTest {
  private final static String SHIP_STRING = "Ship";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = SpecificWarehouseNonConformingConsignmentEnum.SHIP.toString();

    assertEquals(enumResult, SHIP_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = SpecificWarehouseNonConformingConsignmentEnum.SHIP.getValue();

    assertEquals(enumResult, SHIP_STRING);
  }
}