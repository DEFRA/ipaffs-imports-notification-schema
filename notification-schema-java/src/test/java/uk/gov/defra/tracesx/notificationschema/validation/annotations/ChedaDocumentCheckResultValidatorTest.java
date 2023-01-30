package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.DEROGATION;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_DONE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

public class ChedaDocumentCheckResultValidatorTest {

  private ChedaDocumentCheckResultValidator validator;
  private ConsignmentCheck check;

  @Before
  public void setUp() {
    validator = new ChedaDocumentCheckResultValidator();
    check = new ConsignmentCheck();
    validator.initialize(null);
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckSatisfactoryEuStandardAndNationalRequirementNull() {
    assertFalse(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenConsignmentCheckIsNull() {
    Assert.assertTrue(validator.isValid(null, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckSatisfactoryEuStandardNotSetAndNationalRequirementNotSet() {
    check.setDocumentCheckResult(SATISFACTORY);
    check.setEuStandard(NOT_SET);
    check.setNationalRequirements(NOT_SET);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryEuStandardNotSetAndNationalRequirementNotSet() {
    check.setDocumentCheckResult(NOT_SATISFACTORY);
    check.setEuStandard(NOT_SET);
    check.setNationalRequirements(NOT_SET);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckEuStandardAndNationalRequirementNotSatisfactory() {
    check.setDocumentCheckResult(NOT_SATISFACTORY);
    check.setEuStandard(NOT_SATISFACTORY);
    check.setNationalRequirements(NOT_SATISFACTORY);

    assertFalse(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckEuStandardAndNationalRequirementSatisfactory() {
    check.setDocumentCheckResult(SATISFACTORY);
    check.setEuStandard(SATISFACTORY);
    check.setNationalRequirements(SATISFACTORY);

    assertFalse(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckOfficialInterventionEuStandardNotDoneAndNationalRequirementDerogation() {
    check.setDocumentCheckResult(SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION);
    check.setEuStandard(NOT_DONE);
    check.setNationalRequirements(DEROGATION);

    assertFalse(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSetEuStandardSatisfactoryAndNationalRequirementSatisfactory() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(SATISFACTORY);
    check.setNationalRequirements(SATISFACTORY);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSetEuStandardNotSatisfactoryAndNationalRequirementNotSatisfactory() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(NOT_SATISFACTORY);
    check.setNationalRequirements(NOT_SATISFACTORY);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSetEuStandardNotSatisfactoryAndNationalRequirementSatisfactory() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(NOT_SATISFACTORY);
    check.setNationalRequirements(SATISFACTORY);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSetEuStandardSatisfactoryAndNationalRequirementNotSatisfactory() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(SATISFACTORY);
    check.setNationalRequirements(NOT_SATISFACTORY);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckEuStandardAndNationalRequirementNotSet() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(NOT_SET);
    check.setNationalRequirements(NOT_SET);

    assertFalse(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckEuStandardNotSetNationalRequirementSet() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(NOT_SET);
    check.setNationalRequirements(SATISFACTORY);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSetEuStandardNotSatisfactoryNationalRequirementSatisFactory() {
    check.setDocumentCheckResult(NOT_SET);
    check.setEuStandard(NOT_SATISFACTORY);
    check.setNationalRequirements(SATISFACTORY);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNullEuStandardAndNationalRequirementNotSet() {
    check.setEuStandard(NOT_SET);
    check.setNationalRequirements(NOT_SET);

    assertFalse(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckEuStandardNullAndNationalRequirementNotSet() {
    check.setDocumentCheckResult(NOT_SET);
    check.setNationalRequirements(NOT_SET);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckSatisfactoryEuStandardAndNationalRequirementNullt() {
    check.setDocumentCheckResult(SATISFACTORY);
    check.setEuStandard(NOT_SET);

    assertFalse(validator.isValid(check, null));
  }

}