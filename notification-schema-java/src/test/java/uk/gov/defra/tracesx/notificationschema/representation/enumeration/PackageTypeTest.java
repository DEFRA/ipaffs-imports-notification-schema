package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class PackageTypeTest {
  private final static String BAG_STRING = "Bag";

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
}