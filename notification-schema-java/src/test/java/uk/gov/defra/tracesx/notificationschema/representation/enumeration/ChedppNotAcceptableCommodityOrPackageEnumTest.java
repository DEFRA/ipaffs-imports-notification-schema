package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ChedppNotAcceptableCommodityOrPackageEnumTest {
  private final static String COMMODITIES_STRING = "c";

  @Test
  void chedppNotAcceptableCommodityOrPackageEnumShouldReturnValueWhenValueIsValid() {
    ChedppNotAcceptableCommodityOrPackageEnum enumResult = ChedppNotAcceptableCommodityOrPackageEnum
        .fromValue(COMMODITIES_STRING);

    assertThat(enumResult).isEqualTo(ChedppNotAcceptableCommodityOrPackageEnum.COMMODITIES);
  }

  @Test
  void chedppNotAcceptableCommodityOrPackageEnumShouldReturnNullWhenValueIsInvalid() {
    ChedppNotAcceptableCommodityOrPackageEnum enumResult = ChedppNotAcceptableCommodityOrPackageEnum
        .fromValue("invalid");

    assertThat(enumResult).isNull();
  }

  @Test
  void chedppNotAcceptableCommodityOrPackageEnumShouldReturnStringValue() {
    String enumResult = ChedppNotAcceptableCommodityOrPackageEnum.COMMODITIES.toString();

    assertThat(enumResult).isEqualTo(COMMODITIES_STRING);
  }

  @Test
  void chedppNotAcceptableCommodityOrPackageEnumShouldReturnValue() {
    String enumResult = ChedppNotAcceptableCommodityOrPackageEnum.COMMODITIES.getValue();

    assertThat(enumResult).isEqualTo(COMMODITIES_STRING);
  }
}
