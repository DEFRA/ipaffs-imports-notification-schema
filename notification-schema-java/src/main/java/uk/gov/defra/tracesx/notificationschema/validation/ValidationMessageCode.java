package uk.gov.defra.tracesx.notificationschema.validation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ValidationMessageCode extends ValidationMessage {

  public ValidationMessageCode() {
    super();
  }

  public ValidationMessageCode(String field, String message) {
    super(field, message);
  }

  @Override
  @JsonProperty("message")
  public String getMessage() {
    return super.getMessage();
  }

  public String toString() {
    return String.format("ValidationMessageCode(field=%s, message=%s)", getField(), getMessage());
  }
}
