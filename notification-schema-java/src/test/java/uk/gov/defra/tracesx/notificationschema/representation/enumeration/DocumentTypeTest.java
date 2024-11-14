package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class DocumentTypeTest {
  private final static String AIR_WAYBILL_STRING = "airWaybill";
  private final static String INVALID_STRING = "Invalid";

  @Test
  void givenAValidEnumValue_whenToStringCalled_shouldReturnStringValue() {
    String enumResult = DocumentType.AIR_WAYBILL.toString();

    assertThat(enumResult).isEqualTo(AIR_WAYBILL_STRING);
  }

  @Test
  void givenAValidEnumValue_whenGetValueCalled_shouldReturnValue() {
    String enumResult = DocumentType.AIR_WAYBILL.getValue();

    assertThat(enumResult).isEqualTo(AIR_WAYBILL_STRING);
  }

  @Test
  void givenAValueValid_whenFromValueCalled_shouldReturnEnumValue() {
    DocumentType enumResult = DocumentType.fromValue(AIR_WAYBILL_STRING);

    assertThat(enumResult).isEqualTo(DocumentType.AIR_WAYBILL);
  }

  @Test
  void givenAnInvalidValue_whenFromValueCalled_shouldReturnNull() {
    DocumentType enumResult = DocumentType.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}
