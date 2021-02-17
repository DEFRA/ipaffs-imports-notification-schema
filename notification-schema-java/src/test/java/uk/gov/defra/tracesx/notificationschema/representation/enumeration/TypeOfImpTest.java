package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class TypeOfImpTest {
  private final static String LIVE_ANIMALS_STRING = "A";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = TypeOfImp.LIVE_ANIMALS.toString();

    assertEquals(enumResult, LIVE_ANIMALS_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = TypeOfImp.LIVE_ANIMALS.getValue();

    assertEquals(enumResult, LIVE_ANIMALS_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    TypeOfImp enumResult = TypeOfImp.fromValue(LIVE_ANIMALS_STRING);

    assertEquals(enumResult, TypeOfImp.LIVE_ANIMALS);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    TypeOfImp enumResult = TypeOfImp.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
