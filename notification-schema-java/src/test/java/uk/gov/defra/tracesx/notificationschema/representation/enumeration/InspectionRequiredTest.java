package uk.gov.defra.tracesx.notificationschema.representation.enumeration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class InspectionRequiredTest {

  private final static String REQUIRED = "Required";
  private final static String INCONCLUSIVE = "Inconclusive";
  private final static String NOT_REQUIRED = "Not required";
  private final static String INVALID_STRING = "Invalid";

  @Test
  public void givenAValidEnumValue_ReturnStringValue_WhenToStringCalled() {
    String enumResult = InspectionRequired.REQUIRED.toString();

    assertThat(enumResult).isEqualTo(REQUIRED);
  }

  @Test
  public void givenAValidEnumValue_ReturnValue_WhenGetValueCalled() {
    String enumResult = InspectionRequired.INCONCLUSIVE.getValue();

    assertThat(enumResult).isEqualTo(INCONCLUSIVE);
  }

  @Test
  public void givenAValueValid_ReturnEnumValue_WhenFromValueCalled() {
    InspectionRequired enumResult = InspectionRequired.fromValue(NOT_REQUIRED);

    assertThat(enumResult).isEqualTo(InspectionRequired.NOT_REQUIRED);
  }

  @Test
  public void givenAnInvalidValue_ReturnNull_WhenFromValueCalled() {
    InspectionRequired enumResult = InspectionRequired.fromValue(INVALID_STRING);

    assertThat(enumResult).isNull();
  }
}