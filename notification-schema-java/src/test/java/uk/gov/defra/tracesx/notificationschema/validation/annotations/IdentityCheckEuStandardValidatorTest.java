package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

class IdentityCheckEuStandardValidatorTest {

  private ConsignmentCheck check;
  private IdentityCheckResultValidator validator;

  @BeforeEach
  void setUp() {
    validator = new IdentityCheckResultValidator();
    check = new ConsignmentCheck();
  }

  @Test
  void testThatValidatorReturnsTrueIfNullPassed() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueIfIdentityCheckDoneIsFalse() {
    check.setIdentityCheckDone(false);
    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueIfIdentityCheckDoneIsTrueAndResultIsSatisfactory() {
    check.setIdentityCheckDone(true);
    check.setIdentityCheckResult(SATISFACTORY);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueIfIdentityCheckDoneIsTrueAndResultIsNotSatisfactory() {
    check.setIdentityCheckDone(true);
    check.setIdentityCheckResult(NOT_SATISFACTORY);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsFalseIfIdentityCheckDoneIsTrueAndResultIsNull() {
    check.setIdentityCheckDone(true);

    assertThat(validator.isValid(check, null)).isFalse();
  }
}
