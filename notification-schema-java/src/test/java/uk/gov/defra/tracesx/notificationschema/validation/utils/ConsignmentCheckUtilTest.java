package uk.gov.defra.tracesx.notificationschema.validation.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.validation.utils.ConsignmentCheckUtil.isExistingCHEDANotification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

class ConsignmentCheckUtilTest {

  ConsignmentCheck consignmentCheck;

  @BeforeEach
  void setUp() {
    consignmentCheck = new ConsignmentCheck();
  }

  @Test
  void isValid_returnsFalse_whenDocumentCheckSatisfactoryEuStandardAndNationalRequirementNull() {
    assertThat(isExistingCHEDANotification(consignmentCheck)).isFalse();
  }

  @Test
  void isChedAAlreadyCreatedAndChecksSetToEuSatisfactoryAndNationalSatisfactory_thenResultIsTrue() {
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);
    consignmentCheck.setEuStandard(Result.SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.SATISFACTORY);

    assertThat(isExistingCHEDANotification(consignmentCheck)).isTrue();
  }

  @Test
  void isChedAAlreadyCreatedAndChecksSetToEuNotSatisfactoryAndNationalSatisfactory_thenResultIsTrue() {
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);
    consignmentCheck.setEuStandard(Result.NOT_SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.SATISFACTORY);

    assertThat(isExistingCHEDANotification(consignmentCheck)).isTrue();
  }

  @Test
  void isChedAAlreadyCreatedAndChecksSetToEuSatisfactoryAndNationalNotSatisfactory_thenResultIsTrue() {
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);
    consignmentCheck.setEuStandard(Result.SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.NOT_SATISFACTORY);

    assertThat(isExistingCHEDANotification(consignmentCheck)).isTrue();
  }

  @Test
  void isChedAAlreadyCreatedAndChecksSetToEuNotSatisfactoryAndNationalNotSatisfactory_thenResultIsTrue() {
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);
    consignmentCheck.setEuStandard(Result.NOT_SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.NOT_SATISFACTORY);

    assertThat(isExistingCHEDANotification(consignmentCheck)).isTrue();
  }

  @Test
  void isChedANewWithSetToEuSatisfactoryAndNationalSatisfactory_thenResultIsFalse() {
    consignmentCheck.setDocumentCheckResult(Result.SATISFACTORY);
    consignmentCheck.setEuStandard(Result.SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.SATISFACTORY);

    assertThat(isExistingCHEDANotification(consignmentCheck)).isFalse();
  }

  @Test
  void isChedANewWithSetToEuNotSatisfactoryAndNationalSatisfactory_thenResultIsFalse() {
    consignmentCheck.setDocumentCheckResult(Result.SATISFACTORY);
    consignmentCheck.setEuStandard(Result.NOT_SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.SATISFACTORY);

    assertThat(isExistingCHEDANotification(consignmentCheck)).isFalse();
  }

  @Test
  void isChedANewWithSetToEuSatisfactoryAndNationalNotSatisfactory_thenResultIsFalse() {
    consignmentCheck.setDocumentCheckResult(Result.SATISFACTORY);
    consignmentCheck.setEuStandard(Result.SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.NOT_SATISFACTORY);

    assertThat(isExistingCHEDANotification(consignmentCheck)).isFalse();
  }

  @Test
  void isChedANewWithSetToEuNotSatisfactoryAndNationalNotSatisfactory_thenResultIsFalse() {
    consignmentCheck.setDocumentCheckResult(Result.SATISFACTORY);
    consignmentCheck.setEuStandard(Result.NOT_SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.NOT_SATISFACTORY);

    assertThat(isExistingCHEDANotification(consignmentCheck)).isFalse();
  }

}
