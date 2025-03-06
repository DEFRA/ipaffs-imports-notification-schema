package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.DEROGATION;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_DONE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

class ChedaDocumentCheckResultValidatorTest {

  private ChedaDocumentCheckResultValidator validator;
  private ConsignmentCheck check;

  @BeforeEach
  void setUp() {
    validator = new ChedaDocumentCheckResultValidator();
    check = new ConsignmentCheck();
    validator.initialize(null);
  }

  @Test
  void isValid_returnsFalse_whenDocumentCheckSatisfactoryEuStandardAndNationalRequirementNull() {
    assertThat(validator.isValid(check, null)).isFalse();
  }

  @Test
  void isValid_returnsTrue_whenConsignmentCheckIsNull() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckSatisfactoryEuStandardNotSetAndNationalRequirementNotSet() {
    check.setDocumentCheckResult(SATISFACTORY);
    check.setEuStandard(NOT_SET);
    check.setNationalRequirements(NOT_SET);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryEuStandardNotSetAndNationalRequirementNotSet() {
    check.setDocumentCheckResult(NOT_SATISFACTORY);
    check.setEuStandard(NOT_SET);
    check.setNationalRequirements(NOT_SET);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void isValid_returnsFalse_whenDocumentCheckEuStandardAndNationalRequirementNotSatisfactory() {
    check.setDocumentCheckResult(NOT_SATISFACTORY);
    check.setEuStandard(NOT_SATISFACTORY);
    check.setNationalRequirements(NOT_SATISFACTORY);

    assertThat(validator.isValid(check, null)).isFalse();
  }

  @Test
  void isValid_returnsFalse_whenDocumentCheckEuStandardAndNationalRequirementSatisfactory() {
    check.setDocumentCheckResult(SATISFACTORY);
    check.setEuStandard(SATISFACTORY);
    check.setNationalRequirements(SATISFACTORY);

    assertThat(validator.isValid(check, null)).isFalse();
  }

  @Test
  void isValid_returnsFalse_whenDocumentCheckOfficialInterventionEuStandardNotDoneAndNationalRequirementDerogation() {
    check.setDocumentCheckResult(SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION);
    check.setEuStandard(NOT_DONE);
    check.setNationalRequirements(DEROGATION);

    assertThat(validator.isValid(check, null)).isFalse();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckNotSetEuStandardSatisfactoryAndNationalRequirementSatisfactory() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(SATISFACTORY);
    check.setNationalRequirements(SATISFACTORY);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckNotSetEuStandardNotSatisfactoryAndNationalRequirementNotSatisfactory() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(NOT_SATISFACTORY);
    check.setNationalRequirements(NOT_SATISFACTORY);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckNotSetEuStandardNotSatisfactoryAndNationalRequirementSatisfactory() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(NOT_SATISFACTORY);
    check.setNationalRequirements(SATISFACTORY);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckNotSetEuStandardSatisfactoryAndNationalRequirementNotSatisfactory() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(SATISFACTORY);
    check.setNationalRequirements(NOT_SATISFACTORY);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void isValid_returnsFalse_whenDocumentCheckEuStandardAndNationalRequirementNotSet() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(NOT_SET);
    check.setNationalRequirements(NOT_SET);

    assertThat(validator.isValid(check, null)).isFalse();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckEuStandardNotSetNationalRequirementSet() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(NOT_SET);
    check.setNationalRequirements(SATISFACTORY);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckNotSetEuStandardNotSatisfactoryNationalRequirementSatisFactory() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(NOT_SATISFACTORY);
    check.setNationalRequirements(SATISFACTORY);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckEuStandardNullAndNationalRequirementNotSet() {
    check.setDocumentCheckResult(NOT_SET);
    check.setNationalRequirements(NOT_SET);

    assertThat(validator.isValid(check, null)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenDocumentCheckSatisfactoryEuStandardAndNationalRequirementNull() {
    check.setDocumentCheckResult(SATISFACTORY);
    check.setEuStandard(NOT_SET);

    assertThat(validator.isValid(check, null)).isFalse();
  }

  @ParameterizedTest
  @EnumSource(Result.class)
  void isValid_returnsTrue_ForDocumentCheckResultsThatAreNotNotSet(Result result) {
    check.setEuStandard(NOT_SET);
    check.setNationalRequirements(NOT_SET);

    check.setDocumentCheckResult(result);

    if (result != NOT_SET) {
      assertThat(validator.isValid(check, null)).isTrue();
    } else {
      assertThat(validator.isValid(check, null)).isFalse();
    }
  }
}
