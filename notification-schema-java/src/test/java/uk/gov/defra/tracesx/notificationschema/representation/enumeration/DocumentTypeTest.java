package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class DocumentTypeTest {
  private final static String AIR_WAYBILL_STRING = "airWaybill";

  @Test
  public void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = DocumentType.AIR_WAYBILL.toString();

    assertEquals(enumResult, AIR_WAYBILL_STRING);
  }

  @Test
  public void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = DocumentType.AIR_WAYBILL.getValue();

    assertEquals(enumResult, AIR_WAYBILL_STRING);
  }
}