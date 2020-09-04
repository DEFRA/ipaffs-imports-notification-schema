package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertNull;

import org.junit.Test;

public class ChedppNotAcceptableCommodityOrPackageEnumTest {
  private final static String COMMODITIES_STRING = "c";

  @Test
  public void chedppNotAcceptableCommodityOrPackageEnumShouldReturnValueWhenValueIsValid() {
    ChedppNotAcceptableCommodityOrPackageEnum enumResult = ChedppNotAcceptableCommodityOrPackageEnum
        .fromValue(COMMODITIES_STRING);

    assertEquals(enumResult, ChedppNotAcceptableCommodityOrPackageEnum.COMMODITIES);
    assertNotNull(enumResult);
  }

  @Test
  public void chedppNotAcceptableCommodityOrPackageEnumShouldReturnNullWhenValueIsInvalid() {
    ChedppNotAcceptableCommodityOrPackageEnum enumResult = ChedppNotAcceptableCommodityOrPackageEnum
        .fromValue("invalid");

    assertNull(enumResult);
  }

  @Test
  public void chedppNotAcceptableCommodityOrPackageEnumShouldReturnStringValue() {
    String enumResult = ChedppNotAcceptableCommodityOrPackageEnum.COMMODITIES.toString();

    assertEquals(COMMODITIES_STRING, enumResult);
  }

  @Test
  public void chedppNotAcceptableCommodityOrPackageEnumShouldReturnValue() {
    String enumResult = ChedppNotAcceptableCommodityOrPackageEnum.COMMODITIES.getValue();

    assertEquals(enumResult, COMMODITIES_STRING);
  }
}
