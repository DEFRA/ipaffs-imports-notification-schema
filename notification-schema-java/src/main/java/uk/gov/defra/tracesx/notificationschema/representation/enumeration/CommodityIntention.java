package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CommodityIntention {
  HUMAN("human"),
  FEEDINGSTUFF("feedingstuff"),
  FURTHER("further"),
  OTHER("other");

  private String value;

  CommodityIntention(String value) {
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
