package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CentralCompetentAuthorityEnum {
  DEFRA("DEFRA"),
  DAERA("DAERA");

  private String value;

  CentralCompetentAuthorityEnum(String value) {
    this.value = value;
  }

  @JsonCreator
  public static CentralCompetentAuthorityEnum fromValue(String text) {
    for (CentralCompetentAuthorityEnum b : CentralCompetentAuthorityEnum.values()) {
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
