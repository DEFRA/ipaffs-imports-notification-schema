package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class ChedppNotAcceptableReasonEnumTest {
  private final static String DOCPHMDM_STRING = "doc-phmdm";

  @Test
  public void chedppNotAcceptableReasonEnumShouldReturnValueWhenValueIsValid() {
    ChedppNotAcceptableReasonEnum enumResult = ChedppNotAcceptableReasonEnum.fromValue(DOCPHMDM_STRING);

    assertEquals(enumResult, ChedppNotAcceptableReasonEnum.DOCPHMDM);
    assertNotNull(enumResult);
  }

  @Test
  public void chedppNotAcceptableReasonEnumShouldReturnNullWhenValueIsInvalid() {
    ChedppNotAcceptableReasonEnum enumResult = ChedppNotAcceptableReasonEnum.fromValue("invalid");

    assertNull(enumResult);
  }

  @Test
  public void chedppNotAcceptableReasonEnumShouldReturnStringValue() {
    String enumResult = ChedppNotAcceptableReasonEnum.DOCPHMDM.toString();

    assertEquals(DOCPHMDM_STRING, enumResult);
  }
}
