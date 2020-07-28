package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;

public enum NotAcceptableActionReasonEnum {
  CONTAMINATED_PRODUCTS("ContaminatedProducts"),
  THE_INTERCEPTED_PART_OF_THE_CONSIGNMENT("InterceptedPart"),
  PACKAGING_MATERIAL("PackagingMaterial"),
  MEANS_OF_TRANSPORT("MeansOfTransport"),
  OTHER("Other");

  private String value;

  NotAcceptableActionReasonEnum(String value) {
    this.value = value;
  }

  @JsonCreator
  public static NotAcceptableActionReasonEnum fromValue(String text) {
    return Arrays.stream(NotAcceptableActionReasonEnum.values())
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