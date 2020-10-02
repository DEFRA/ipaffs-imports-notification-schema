package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class AnimalCertificationTest {
  private final static String APPROVED_STRING = "Approved";

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
}