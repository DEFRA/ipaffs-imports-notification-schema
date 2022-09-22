package uk.gov.defra.tracesx.notificationschema.validation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ValidationMessageTest {

  private static final String VALUE = "set value";
  private final ValidationMessage testSubject = new ValidationMessage();

  @Test
  public void setField() {
    testSubject.setField(VALUE);
    assertThat(testSubject.getField()).isEqualTo(VALUE);
  }

  @Test
  public void setMessage() {
    testSubject.setMessage(VALUE);
    assertThat(testSubject.getMessage()).isEqualTo(VALUE);
  }
}