package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;

public enum ChedppNotAcceptableCommodityOrPackageEnum {
  COMMODITIES("c"),
  PACKAGE("p"),
  COMMODITIESANDPACKAGES("cp");

  private String value;

  ChedppNotAcceptableCommodityOrPackageEnum(String value) {
    this.value = value;
  }

  public static ChedppNotAcceptableCommodityOrPackageEnum fromValue(String text) {
    return Arrays.stream(ChedppNotAcceptableCommodityOrPackageEnum.values())
        .filter(label -> label.value.equals(text))
        .findFirst()
        .orElse(null);
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
