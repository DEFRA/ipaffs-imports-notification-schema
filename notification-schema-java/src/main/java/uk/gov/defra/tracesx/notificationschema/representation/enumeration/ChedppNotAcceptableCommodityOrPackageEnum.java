package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum ChedppNotAcceptableCommodityOrPackageEnum {
  COMMODITIES("c"),
  PACKAGE("p"),
  COMMODITIESANDPACKAGES("cp");

  private String value;

  ChedppNotAcceptableCommodityOrPackageEnum(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ChedppNotAcceptableCommodityOrPackageEnum fromValue(String text) {
    for (ChedppNotAcceptableCommodityOrPackageEnum b : ChedppNotAcceptableCommodityOrPackageEnum
        .values()) {
      if (b.value.equals(text)) {
        return b;
      }
    }
    return null;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return value;
  }
}
