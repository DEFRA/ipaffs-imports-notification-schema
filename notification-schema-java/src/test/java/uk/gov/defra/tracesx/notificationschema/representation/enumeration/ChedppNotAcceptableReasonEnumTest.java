package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ChedppNotAcceptableReasonEnumTest {
  private final static String DOCPHMDM_STRING = "doc-phmdm";

  @Test
  void chedppNotAcceptableReasonEnumShouldReturnValueWhenValueIsValid() {
    ChedppNotAcceptableReasonEnum enumResult = ChedppNotAcceptableReasonEnum.fromValue(DOCPHMDM_STRING);

    assertThat(enumResult).isEqualTo(ChedppNotAcceptableReasonEnum.DOCPHMDM);
  }

  @Test
  void chedppNotAcceptableReasonEnumShouldReturnNullWhenValueIsInvalid() {
    ChedppNotAcceptableReasonEnum enumResult = ChedppNotAcceptableReasonEnum.fromValue("invalid");

    assertThat(enumResult).isNull();
  }

  @Test
  void chedppNotAcceptableReasonEnumShouldReturnStringValue() {
    String enumResult = ChedppNotAcceptableReasonEnum.DOCPHMDM.toString();

    assertThat(enumResult).isEqualTo(DOCPHMDM_STRING);
  }

  @Test
  void chedppNotAcceptableReasonEnumShouldReturnValue() {
    String enumResult = ChedppNotAcceptableReasonEnum.DOCPHMDM.getValue();

    assertThat(enumResult).isEqualTo(DOCPHMDM_STRING);
  }
}
