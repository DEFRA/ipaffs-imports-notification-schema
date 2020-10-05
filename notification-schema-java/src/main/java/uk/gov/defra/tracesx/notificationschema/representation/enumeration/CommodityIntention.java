package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
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

  @JsonCreator
  public static CommodityIntention fromValue(String text) {
    for (CommodityIntention b : CommodityIntention.values()) {
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
