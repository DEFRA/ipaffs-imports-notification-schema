package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

class PhysicalCheckResultTest {

  private PhysicalCheckResultValidator validator;
  private ConsignmentCheck consignmentCheck;

  @BeforeEach
  void setUp() {
    validator = new PhysicalCheckResultValidator();
    consignmentCheck = new ConsignmentCheck();
  }

  @Test
  void testThatValidatorReturnsTrueIfNullPassed() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueIfPhysicalCheckResultReturnsNull() {
    assertThat(validator.isValid(new ConsignmentCheck(), null)).isTrue();
  }

  @Test
  void
  testThatValidatorReturnsFalseIfPhysicalCheckResultReturnsTrueButPhysicalCheckResultReturnsNull() {
    consignmentCheck.setPhysicalCheckDone(true);

    assertThat(validator.isValid(consignmentCheck, null)).isFalse();
  }

  @Test
  void
  testThatValidatorReturnsTrueIfPhysicalCheckResultReturnsFalseButPhysicalCheckResultReturnsNull() {
    consignmentCheck.setPhysicalCheckDone(false);

    assertThat(validator.isValid(consignmentCheck, null)).isTrue();
  }

  @Test
  void
  testThatValidatorReturnsTrueIfPhysicalCheckResultReturnsTrueAndPhysicalCheckResultReturnsSatisfactory() {
    consignmentCheck.setPhysicalCheckDone(true);
    consignmentCheck.setPhysicalCheckResult(SATISFACTORY);

    assertThat(validator.isValid(consignmentCheck, null)).isTrue();
  }

  @Test
  void
  testThatValidatorReturnsTrueIfPhysicalCheckResultReturnsTrueAndPhysicalCheckResultReturnsNotSatisfactory() {
    consignmentCheck.setPhysicalCheckDone(true);
    consignmentCheck.setPhysicalCheckResult(NOT_SATISFACTORY);

    assertThat(validator.isValid(consignmentCheck, null)).isTrue();
  }

  @Test
  void
  testThatValidatorReturnsTrueIfPhysicalCheckResultReturnsFalseAndPhysicalCheckResultReturnsSatisfactory() {
    consignmentCheck.setPhysicalCheckDone(false);
    consignmentCheck.setPhysicalCheckResult(SATISFACTORY);

    assertThat(validator.isValid(consignmentCheck, null)).isTrue();
  }

  @Test
  void
  testThatValidatorReturnsTrueIfPhysicalCheckResultReturnsFalseAndPhysicalCheckResultReturnsNotSatisfactory() {
    consignmentCheck.setPhysicalCheckDone(false);
    consignmentCheck.setPhysicalCheckResult(NOT_SATISFACTORY);

    assertThat(validator.isValid(consignmentCheck, null)).isTrue();
  }
}
