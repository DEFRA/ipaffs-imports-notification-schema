package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.DEROGATION;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_DONE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotificationTypeEnum;

public class DocumentEuStandardAndNationalRequirementsCheckResultValidatorTest {

  private DocumentEuStandardAndNationalRequirementsCheckResultValidator validator;
  private Notification notification;
  private PartTwo partTwo;
  private ConsignmentCheck check;

  @Before
  public void setUp() {
    validator = new DocumentEuStandardAndNationalRequirementsCheckResultValidator();
    partTwo = new PartTwo();
    notification = new Notification();
    notification.setPartTwo(partTwo);
    check = new ConsignmentCheck();
    partTwo.setConsignmentCheck(check);
  }

  @Test
  public void isValid_returnsTrue_whenConsignmentCheckIsNull() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckSatisfactoryEuStandardNotSetAndNationalRequirementNotSet() {
    notification.setType(NotificationTypeEnum.CVEDA);
    check.setEuStandard(NOT_SET);
    check.setNationalRequirements(NOT_SET);
    check.setDocumentCheckResult(SATISFACTORY);

    assertTrue(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryEuStandardNotSetAndNationalRequirementNotSet() {
    notification.setType(NotificationTypeEnum.CVEDA);
    check.setEuStandard(NOT_SET);
    check.setNationalRequirements(NOT_SET);
    check.setDocumentCheckResult(NOT_SATISFACTORY);

    assertTrue(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSetEuStandardSatisfactoryAndNationalRequirementSatisfactory() {
    notification.setType(NotificationTypeEnum.CVEDA);
    check.setEuStandard(SATISFACTORY);
    check.setNationalRequirements(SATISFACTORY);
    check.setDocumentCheckResult(NOT_SET);

    assertTrue(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSetEuStandardNotSatisfactoryAndNationalRequirementNotSatisfactory() {
    notification.setType(NotificationTypeEnum.CVEDA);
    check.setEuStandard(NOT_SATISFACTORY);
    check.setNationalRequirements(NOT_SATISFACTORY);
    check.setDocumentCheckResult(NOT_SET);

    assertTrue(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckEuStandardAndNationalRequirementNotSet() {
    notification.setType(NotificationTypeEnum.CVEDA);
    check.setEuStandard(NOT_SET);
    check.setNationalRequirements(NOT_SET);
    check.setDocumentCheckResult(NOT_SET);

    assertFalse(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckEuStandardAndNationalRequirementNotSatisfactory() {
    notification.setType(NotificationTypeEnum.CVEDA);
    check.setEuStandard(NOT_SATISFACTORY);
    check.setNationalRequirements(NOT_SATISFACTORY);
    check.setDocumentCheckResult(NOT_SATISFACTORY);

    assertFalse(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckEuStandardAndNationalRequirementSatisfactory() {
    notification.setType(NotificationTypeEnum.CVEDA);
    check.setEuStandard(SATISFACTORY);
    check.setNationalRequirements(SATISFACTORY);
    check.setDocumentCheckResult(SATISFACTORY);

    assertFalse(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckEuStandardAndNationalRequirementSatisfactoryFollowingOfficialIntervention() {
    notification.setType(NotificationTypeEnum.CVEDA);
    check.setEuStandard(SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION);
    check.setNationalRequirements(SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION);
    check.setDocumentCheckResult(SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION);

    assertFalse(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckEuStandardAndNationalRequirementNotDone() {
    notification.setType(NotificationTypeEnum.CVEDA);
    check.setEuStandard(NOT_DONE);
    check.setNationalRequirements(NOT_DONE);
    check.setDocumentCheckResult(NOT_DONE);

    assertFalse(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckEuStandardAndNationalRequirementDerogation() {
    notification.setType(NotificationTypeEnum.CVEDA);
    check.setEuStandard(DEROGATION);
    check.setNationalRequirements(DEROGATION);
    check.setDocumentCheckResult(DEROGATION);

    assertFalse(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckOfficialInterventionEuStandardNotDoneAndNationalRequirementDerogation() {
    notification.setType(NotificationTypeEnum.CVEDA);
    check.setEuStandard(NOT_DONE);
    check.setNationalRequirements(DEROGATION);
    check.setDocumentCheckResult(SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION);

    assertFalse(validator.isValid(notification, null));
  }

}
