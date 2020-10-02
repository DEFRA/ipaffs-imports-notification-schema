package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ImpQuantityDataKeysTest {
  private final static String QUANTITY_STRING = "quantity";

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
}