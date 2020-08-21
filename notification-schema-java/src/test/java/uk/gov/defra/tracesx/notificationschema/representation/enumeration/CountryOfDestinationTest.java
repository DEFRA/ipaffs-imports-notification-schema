package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class CountryOfDestinationTest {
  private final static String NI_STRING = "XI";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = CountryOfDestinationEnum.NI.toString();

    assertEquals(enumResult, NI_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = CountryOfDestinationEnum.NI.getValue();

    assertEquals(enumResult, NI_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    CountryOfDestinationEnum enumResult = CountryOfDestinationEnum.fromValue(NI_STRING);

    assertEquals(enumResult, CountryOfDestinationEnum.NI);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    CountryOfDestinationEnum enumResult = CountryOfDestinationEnum.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
