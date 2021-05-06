package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

public class IsPositiveDoubleKeyDataPairValidationTest {
  private IsPositiveDoubleKeyDataPairValidation validator;
  private String data;

  @Before
  public void setup() {
    validator = new IsPositiveDoubleKeyDataPairValidation("quantity");
  }

  @Test
  public void isValid_ReturnsFalse_WhenFieldValueIsNull() {
    data = null;
    assertThat(validator.isValid(data)).isFalse();
  }

  @Test
  public void isValid_ReturnsFalse_WhenFieldValueIsNonPositiveNumber() {
    data = "-1";
    assertThat(validator.isValid(data)).isFalse();
  }

  @Test
  public void isValid_ReturnsTrue_WhenFieldValueGreaterThanZero() {
    data = "1";
    assertThat(validator.isValid(data)).isTrue();
  }

  @Test
  public void isValid_ReturnsFalse_WhenFieldValueIsNotANumber() {
    data = "??";
    assertThat(validator.isValid(data)).isFalse();
  }

  @Test
  public void isValid_ReturnsFalse_WhenFieldValueIsZero() {
    data = "0";
    assertThat(validator.isValid(data)).isFalse();
  }

  @Test
  public void isValid_ReturnsTrue_WhenFieldValueIsPositiveDecimal() {
    data = "1.5";
    assertThat(validator.isValid(data)).isTrue();
  }
}
