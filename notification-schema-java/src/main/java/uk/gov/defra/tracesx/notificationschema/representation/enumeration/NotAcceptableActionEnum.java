package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import uk.gov.defra.tracesx.notificationschema.validation.CED;
import uk.gov.defra.tracesx.notificationschema.validation.CVEDA;
import uk.gov.defra.tracesx.notificationschema.validation.CVEDP;
import uk.gov.defra.tracesx.notificationschema.validation.EntityProperty;

public enum NotAcceptableActionEnum implements EntityProperty {
  @CVEDA
  SLAUGHTER("slaughter"),
  @CVEDP
  @CVEDA
  REEXPORT("reexport"),
  @CVEDA
  EUTHANASIA("euthanasia"),
  @CED
  REDISPATCHING("redispatching"),
  @CED
  @CVEDP
  DESTRUCTION("destruction"),
  @CED
  @CVEDP
  TRANSFORMATION("transformation"),
  @CED
  OTHER("other");

  private String value;

  NotAcceptableActionEnum(String value) {
    this.value = value;
  }

  @JsonCreator
  public static NotAcceptableActionEnum fromValue(String text) {
    for (NotAcceptableActionEnum b : NotAcceptableActionEnum.values()) {
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
