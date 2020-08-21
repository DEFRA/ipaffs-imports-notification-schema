package uk.gov.defra.tracesx.notificationschema.validation;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@ToString
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
}
