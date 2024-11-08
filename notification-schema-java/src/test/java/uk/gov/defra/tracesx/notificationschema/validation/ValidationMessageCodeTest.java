package uk.gov.defra.tracesx.notificationschema.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ValidationMessageCodeTest {

  @Test
  void toString_PrintsTheCorrectFields() {
    ValidationMessageCode validationMessageCode = new ValidationMessageCode("fieldValue",
        "messageValue");

    assertThat(validationMessageCode)
        .hasToString("ValidationMessageCode(field=fieldValue, message=messageValue)");
  }

  @Test
  void defaultConstructor_InitialisesWithNullValues() {
    ValidationMessageCode validationMessageCode = new ValidationMessageCode();

    assertThat(validationMessageCode)
        .hasToString("ValidationMessageCode(field=null, message=null)");
  }
}
