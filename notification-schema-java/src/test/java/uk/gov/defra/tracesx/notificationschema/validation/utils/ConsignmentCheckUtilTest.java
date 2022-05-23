package uk.gov.defra.tracesx.notificationschema.validation.utils;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.validation.utils.ConsignmentCheckUtil.isExistingCHEDANotification;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

public class ConsignmentCheckUtilTest {

  ConsignmentCheck consignmentCheck;

  @Before
  public void setUp() throws Exception {
    consignmentCheck = new ConsignmentCheck();
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckSatisfactoryEuStandardAndNationalRequirementNull() {
    assertFalse(isExistingCHEDANotification(consignmentCheck));
  }

  @Test
  public void isChedAAlreadyCreatedAndChecksSetToEuSatisfactoryAndNationalSatisfactory_thenResultIsTrue() {
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);
    consignmentCheck.setEuStandard(Result.SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.SATISFACTORY);

    assertTrue(isExistingCHEDANotification(consignmentCheck));
  }

  @Test
  public void isChedAAlreadyCreatedAndChecksSetToEuNotSatisfactoryAndNationalSatisfactory_thenResultIsTrue() {
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);
    consignmentCheck.setEuStandard(Result.NOT_SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.SATISFACTORY);

    assertTrue(isExistingCHEDANotification(consignmentCheck));
  }

  @Test
  public void isChedAAlreadyCreatedAndChecksSetToEuSatisfactoryAndNationalNotSatisfactory_thenResultIsTrue() {
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);
    consignmentCheck.setEuStandard(Result.SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.NOT_SATISFACTORY);

    assertTrue(isExistingCHEDANotification(consignmentCheck));
  }

  @Test
  public void isChedAAlreadyCreatedAndChecksSetToEuNotSatisfactoryAndNationalNotSatisfactory_thenResultIsTrue() {
    consignmentCheck.setDocumentCheckResult(Result.NOT_SET);
    consignmentCheck.setEuStandard(Result.NOT_SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.NOT_SATISFACTORY);

    assertTrue(isExistingCHEDANotification(consignmentCheck));
  }

  @Test
  public void isChedANewWithSetToEuSatisfactoryAndNationalSatisfactory_thenResultIsFalse() {
    consignmentCheck.setDocumentCheckResult(Result.SATISFACTORY);
    consignmentCheck.setEuStandard(Result.SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.SATISFACTORY);

    assertFalse(isExistingCHEDANotification(consignmentCheck));
  }

  @Test
  public void isChedANewWithSetToEuNotSatisfactoryAndNationalSatisfactory_thenResultIsFalse() {
    consignmentCheck.setDocumentCheckResult(Result.SATISFACTORY);
    consignmentCheck.setEuStandard(Result.NOT_SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.SATISFACTORY);

    assertFalse(isExistingCHEDANotification(consignmentCheck));
  }

  @Test
  public void isChedANewWithSetToEuSatisfactoryAndNationalNotSatisfactory_thenResultIsFalse() {
    consignmentCheck.setDocumentCheckResult(Result.SATISFACTORY);
    consignmentCheck.setEuStandard(Result.SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.NOT_SATISFACTORY);

    assertFalse(isExistingCHEDANotification(consignmentCheck));
  }

  @Test
  public void isChedANewWithSetToEuNotSatisfactoryAndNationalNotSatisfactory_thenResultIsFalse() {
    consignmentCheck.setDocumentCheckResult(Result.SATISFACTORY);
    consignmentCheck.setEuStandard(Result.NOT_SATISFACTORY);
    consignmentCheck.setNationalRequirements(Result.NOT_SATISFACTORY);

    assertFalse(isExistingCHEDANotification(consignmentCheck));
  }

}