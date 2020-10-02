package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class ChedppNotAcceptableReasonEnumTest {
  private final static String DOCPHMDM_STRING = "doc-phmdm";

  @Test
  public void chedppNotAcceptableReasonEnumShouldReturnStringValue() {
    String enumResult = ChedppNotAcceptableReasonEnum.DOCPHMDM.toString();

    assertEquals(DOCPHMDM_STRING, enumResult);
  }

  @Test
  public void chedppNotAcceptableReasonEnumShouldReturnValue() {
    String enumResult = ChedppNotAcceptableReasonEnum.DOCPHMDM.getValue();

    assertEquals(DOCPHMDM_STRING, enumResult);
  }
}
