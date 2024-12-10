package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentificationCheckType.FULL_IDENTITY_CHECK;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentificationCheckType.SEAL_CHECK;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

class IdentityCheckTypeValidatorTest {

  private ConsignmentCheck check;
  private IdentityCheckTypeValidator validator;

  @BeforeEach
  void setUp() {
    validator = new IdentityCheckTypeValidator();
    check = new ConsignmentCheck();
  }

  @Test
  void testThatValidatorReturnsTrueIfNullPassed() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueIfIdentityCheckResultIsNotSatisfactory() {
    check.setIdentityCheckResult(NOT_SATISFACTORY);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueIfIdentityCheckResultIsSatisfactoryAndTypeIsSealCheck() {
    check.setIdentityCheckResult(SATISFACTORY);
    check.setIdentityCheckType(SEAL_CHECK);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void
  testThatValidatorReturnsTrueIfIdentityCheckResultIsSatisfactoryAndTypeIsFullIdentityCheck() {
    check.setIdentityCheckResult(SATISFACTORY);
    check.setIdentityCheckType(FULL_IDENTITY_CHECK);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsFalseIfIdentityCheckResultIsSatisfactoryButTypeIsNull() {
    check.setIdentityCheckResult(SATISFACTORY);

    assertThat(validator.isValid(check, null)).isFalse();
  }
}
