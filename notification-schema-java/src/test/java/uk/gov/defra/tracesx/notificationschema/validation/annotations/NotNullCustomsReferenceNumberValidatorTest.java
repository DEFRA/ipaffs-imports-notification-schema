package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

class NotNullCustomsReferenceNumberValidatorTest {

  private PartOne partOne;
  private NotNullCustomsReferenceNumberValidator validator;

  @BeforeEach
  void setUp() {
    partOne = new PartOne();
    validator = new NotNullCustomsReferenceNumberValidator();
  }

  @Test
  void validatorReturnsFalse_ifNoPartOne() {
    assertThat(validator.isValid(null, null)).isFalse();
  }

  @Test
  void validatorReturnsFalse_ifNoCustomsReferenceNumber() {
    assertThat(validator.isValid(partOne, null)).isFalse();
  }

  @Test
  void validatorReturnsTrue_ifCustomsReferenceNumber() {
    partOne.setCustomsReferenceNumber("ABCD1234");

    assertThat(validator.isValid(partOne, null)).isTrue();
  }

  @Test
  void validatorReturnsFalse_ifEmptyCustomsReferenceNumber() {
    partOne.setCustomsReferenceNumber("");

    assertThat(validator.isValid(partOne, null)).isFalse();
  }
}
