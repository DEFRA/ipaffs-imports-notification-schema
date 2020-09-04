package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class SpecificWarehouseNonConformingConsignmentEnumTest {
  private final static String SHIP_STRING = "Ship";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    SpecificWarehouseNonConformingConsignmentEnum enumResult = SpecificWarehouseNonConformingConsignmentEnum.fromValue(SHIP_STRING);

    assertEquals(enumResult, SpecificWarehouseNonConformingConsignmentEnum.SHIP);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    SpecificWarehouseNonConformingConsignmentEnum enumResult = SpecificWarehouseNonConformingConsignmentEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
