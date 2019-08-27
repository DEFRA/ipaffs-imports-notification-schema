package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PlaceOfControl {

  AIRPORT("airport"),
  EN_ROUTE("enroute"),
  APPROVED_BODY("approvedbody"),
  ASSEMBLY_CENTER("assemblycenter"),
  EXIT_POINT("exitpoint"),
  PORT("port"),
  ESTABLISH("etablish"),
  OTHER("other"),
  SEMEN_CENTER("semen"),
  DEALERS_PREMISE("dealerspremise"),
  HOLDING("holding"),
  CONTROL_POST("controlpost");

  private String value;

  PlaceOfControl(String value) {
    this.value = value;
  }

  @JsonCreator
  public static PlaceOfControl fromValue(String text) {
    for (PlaceOfControl u : PlaceOfControl.values()) {
      if (u.value.equals(text)) {
        return u;
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
