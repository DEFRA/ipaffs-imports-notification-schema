package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.Notification;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotificationTypeEnum;

public class DocumentCheckResultValidatorTest {

  private DocumentCheckResultValidator validator;
  private Notification notification;
  private PartTwo partTwo;
  private ConsignmentCheck check;

  @Before
  public void setUp() {
    validator = new DocumentCheckResultValidator();
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
  public void isValid_returnsTrue_whenDocumentCheckIsNull() {
    assertTrue(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckResultIsNotSet() {
    check.setDocumentCheckResult(NOT_SET);

    assertFalse(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckResultIsSatisfactoryFollowingOfficialIntervention() {
    check.setDocumentCheckResult(SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION);

    assertFalse(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckResultIsSatisfactory() {
    check.setDocumentCheckResult(SATISFACTORY);

    assertTrue(validator.isValid(notification, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckResultIsNotSatisfactory() {
    check.setDocumentCheckResult(NOT_SATISFACTORY);

    assertTrue(validator.isValid(notification, null));
  }

}
