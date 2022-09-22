package uk.gov.defra.tracesx.notificationschema.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ValidationMessageCodeTest {

  @Test
  public void toString_PrintsTheCorrectFields() {
    ValidationMessageCode validationMessageCode = new ValidationMessageCode("fieldValue",
        "messageValue");

    assertThat(validationMessageCode)
        .hasToString("ValidationMessageCode(field=fieldValue, message=messageValue)");
  }

  @Test
  public void defaultConstructor_InitialisesWithNullValues() {
    ValidationMessageCode validationMessageCode = new ValidationMessageCode();

    assertThat(validationMessageCode)
        .hasToString("ValidationMessageCode(field=null, message=null)");
  }
}
