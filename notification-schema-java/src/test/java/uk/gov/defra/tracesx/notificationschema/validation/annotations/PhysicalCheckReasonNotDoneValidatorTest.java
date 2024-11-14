package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static java.lang.Boolean.FALSE;
import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhysicalCheckNotDoneReason.OTHER;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhysicalCheckNotDoneReason.REDUCED_CHECKS_REGIME;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_DONE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

class PhysicalCheckReasonNotDoneValidatorTest {

  private PhysicalCheckReasonNotDoneValidator validator;

  @BeforeEach
  void setUp() {
    validator = new PhysicalCheckReasonNotDoneValidator();
  }

  @Test
  void testThatValidatorReturnsTrueIfNullPassed() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueIfIsPhysicalCheckDoneReturnsNull() {
    ConsignmentCheck check = new ConsignmentCheck();

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void
  testThatValidatorReturnsFalseIfPhysicalCheckIsNotDoneAndPhysicalCheckNotDoneReasonIsNull() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setPhysicalCheckResult(NOT_DONE);

    assertThat(validator.isValid(check, null)).isFalse();
  }

  @Test
  void
  testThatValidatorReturnsTrueIfPhysicalCheckIsNotDoneAndPhysicalCheckNotDoneReasonIsReducedChecksRegime() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setPhysicalCheckDone(FALSE);
    check.setPhysicalCheckNotDoneReason(REDUCED_CHECKS_REGIME);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void
  testThatValidatorReturnsTrueIfPhysicalCheckIsNotDoneAndPhysicalCheckNotDoneReasonIsOther() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setPhysicalCheckDone(FALSE);
    check.setPhysicalCheckNotDoneReason(OTHER);

    assertThat(validator.isValid(check, null)).isTrue();
  }
}
