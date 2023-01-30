package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class ImpQuantityDataKeysTest {
  private final static String QUANTITY_STRING = "quantity";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = ImpQuantityDataKeys.QUANTITY.toString();

    assertEquals(enumResult, QUANTITY_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = ImpQuantityDataKeys.QUANTITY.getValue();

    assertEquals(enumResult, QUANTITY_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    ImpQuantityDataKeys enumResult = ImpQuantityDataKeys.fromValue(QUANTITY_STRING);

    assertEquals(enumResult, ImpQuantityDataKeys.QUANTITY);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    ImpQuantityDataKeys enumResult = ImpQuantityDataKeys.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
