package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.FALSE;
import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentityCheckNotDoneReason.NOT_REQUIRED;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentityCheckNotDoneReason.REDUCED_CHECKS_REGIME;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_DONE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

class IdentityCheckReasonNotDoneValidatorTest {

  private IdentityCheckReasonNotDoneValidator validator;

  @BeforeEach
  void setUp() {
    validator = new IdentityCheckReasonNotDoneValidator();
  }

  @Test
  void testThatValidatorReturnsTrueIfNullPassed() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueIfIsIdentityCheckDoneReturnsNull() {
    ConsignmentCheck check = new ConsignmentCheck();

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsFalseIfIdentityCheckIsNotDoneAndIdentityCheckNotDoneReasonIsNull() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setIdentityCheckResult(NOT_DONE);

    assertThat(validator.isValid(check, null)).isFalse();
  }

  @Test
  void testThatValidatorReturnsTrueIfIdentityCheckIsNotDoneAndIdentityCheckNotDoneReasonIsReducedChecksRegime() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setIdentityCheckDone(FALSE);
    check.setIdentityCheckResult(NOT_DONE);
    check.setIdentityCheckNotDoneReason(REDUCED_CHECKS_REGIME);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueIfIdentityCheckIsNotDoneAndIdentityCheckNotDoneReasonIsNotRequired() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setIdentityCheckDone(FALSE);
    check.setIdentityCheckResult(NOT_DONE);
    check.setIdentityCheckNotDoneReason(NOT_REQUIRED);

    assertThat(validator.isValid(check, null)).isTrue();
  }
}
