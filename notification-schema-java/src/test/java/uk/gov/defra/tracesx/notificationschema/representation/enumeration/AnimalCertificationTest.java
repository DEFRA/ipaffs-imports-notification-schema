package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class AnimalCertificationTest {
  private final static String APPROVED_STRING = "Approved";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = AnimalCertification.APPROVED.toString();

    assertEquals(enumResult, APPROVED_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = AnimalCertification.APPROVED.getValue();

    assertEquals(enumResult, APPROVED_STRING);
  }

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    AnimalCertification enumResult = AnimalCertification.fromValue(APPROVED_STRING);

    assertEquals(enumResult, AnimalCertification.APPROVED);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    AnimalCertification enumResult = AnimalCertification.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
