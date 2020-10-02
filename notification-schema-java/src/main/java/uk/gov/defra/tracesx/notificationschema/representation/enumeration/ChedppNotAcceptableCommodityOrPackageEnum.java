package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ChedppNotAcceptableCommodityOrPackageEnum {
  COMMODITIES("c"),
  PACKAGE("p"),
  COMMODITIESANDPACKAGES("cp");

  private String value;

  ChedppNotAcceptableCommodityOrPackageEnum(String value) {
    this.value = value;
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