package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class DocumentTypeTest {
  private final static String AIR_WAYBILL_STRING = "airWaybill";
  private final static String INVALID_STRING = "Invalid";

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

  @Test
  public void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    DocumentType enumResult = DocumentType.fromValue(AIR_WAYBILL_STRING);

    assertEquals(enumResult, DocumentType.AIR_WAYBILL);
  }

  @Test
  public void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    DocumentType enumResult = DocumentType.fromValue(INVALID_STRING);

    assertNull(enumResult);
  }
}
