package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum  ActionFollowingQuarantine {

  HUMANE_KILLING("humankilling"),
  RELEASE("release");

  private String value;

  ActionFollowingQuarantine(String value) {
    this.value = value;
  }

  @JsonCreator
  public static ActionFollowingQuarantine fromValue(String text) {
    for (ActionFollowingQuarantine u : ActionFollowingQuarantine.values()) {
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
