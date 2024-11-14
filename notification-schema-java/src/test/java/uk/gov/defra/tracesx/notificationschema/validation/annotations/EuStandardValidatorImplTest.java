package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

class EuStandardValidatorImplTest {

  private EuStandardValidatorImpl validator;

  @BeforeEach
  void setUp() {
    validator = new EuStandardValidatorImpl();
  }

  @Test
  void givenEuStandardIsSatisfactory_whenICallIsValid_thenResultIsTrue() {
    ConsignmentCheck consignmentCheck = new ConsignmentCheck();
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);
    consignmentCheck.setEuStandard(Result.SATISFACTORY);

    assertThat(validator.isValid(consignmentCheck, null)).isTrue();
  }

  @Test
  void givenEuStandardIsNotSetAndNationalRequirementsSatisfactory_whenICallIsValid_thenResultIsTrue() {
    ConsignmentCheck consignmentCheck = new ConsignmentCheck();
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);
    consignmentCheck.setEuStandard(Result.NOT_SET);
    consignmentCheck.setNationalRequirements(Result.SATISFACTORY);

    assertThat(validator.isValid(consignmentCheck, null)).isFalse();
  }

  @Test
  void givenEuStandardIsNotSet_whenICallIsValid_thenResultIsFalse() {
    ConsignmentCheck consignmentCheck = new ConsignmentCheck();
    consignmentCheck.setEuStandard(Result.NOT_SET);
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);
    consignmentCheck.setNationalRequirements(Result.SATISFACTORY);

    assertThat(validator.isValid(consignmentCheck, null)).isFalse();
  }

  @Test
  void newNotification_withNotSetChecks_thenResultIsTrue() {
    ConsignmentCheck consignmentCheck = new ConsignmentCheck();
    consignmentCheck.setEuStandard(Result.NOT_SET);
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);
    consignmentCheck.setNationalRequirements(Result.NOT_SET);

    assertThat(validator.isValid(consignmentCheck, null)).isTrue();
  }

  @Test
  void newNotification_thenResultIsTrue() {
    ConsignmentCheck consignmentCheck = new ConsignmentCheck();
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);

    assertThat(validator.isValid(consignmentCheck, null)).isTrue();
  }

  @Test
  void validate_documentCheckNotSetEuStandardAndNationalRequirementChecksSet_thenResultIsTrue() {
    ConsignmentCheck consignmentCheck = new ConsignmentCheck();
    consignmentCheck.setEuStandard(Result.NOT_SET);
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);
    consignmentCheck.setNationalRequirements(Result.NOT_SET);

    assertThat(validator.isValid(consignmentCheck, null)).isTrue();
  }

  @Test
  void validate_documentCheckIstSetEuStandardAndNationalRequirementChecksNotSet_thenResultIsTrue() {
    ConsignmentCheck consignmentCheck = new ConsignmentCheck();
    consignmentCheck.setEuStandard(Result.NOT_SET);
    consignmentCheck.setDocumentCheckResult(Result.SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.NOT_SET);

    assertThat(validator.isValid(consignmentCheck, null)).isTrue();
  }

  @Test
  void isValid_returnsTrue_whenConsignmentCheckIsNull() {
    assertThat(validator.isValid(null, null)).isTrue();
  }
}
