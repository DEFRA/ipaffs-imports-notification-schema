package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

class HighRiskEUDocumentCheckResultValidatorTest {

  private HighRiskEUDocumentCheckResultValidator validator;

  @BeforeEach
  void setUp() {
    validator = new HighRiskEUDocumentCheckResultValidator();
  }

  @Test
  void isValid_returnsTrue_whenConsignmentCheckIsNull() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckIsNull() {
    ConsignmentCheck check = new ConsignmentCheck();

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void isValid_returnsFalse_whenDocumentCheckIsNotSet() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setDocumentCheckResult(NOT_SET);

    assertThat(validator.isValid(check, null)).isFalse();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckResultIsSatisfactoryFollowingOfficialIntervention() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setDocumentCheckResult(SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckResultIsSatisfactory() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setDocumentCheckResult(SATISFACTORY);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckResultIsNotSatisfactory() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setDocumentCheckResult(NOT_SATISFACTORY);

    assertThat(validator.isValid(check, null)).isTrue();
  }
}
