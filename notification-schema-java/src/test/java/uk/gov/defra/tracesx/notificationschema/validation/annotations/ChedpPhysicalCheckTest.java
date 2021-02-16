package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentificationCheckType.FULL_IDENTITY_CHECK;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;

public class ChedpPhysicalCheckTest {

  private ChedpPhysicalCheckValidator validator;
  private PartTwo partTwo;

  @Before
  public void setUp() {
    validator = new ChedpPhysicalCheckValidator();
    partTwo = new PartTwo();
  }

  @Test
  public void isValid_returnsFalse_whenPartTwoNull() {
    assertFalse(validator.isValid(null, null));
  }

  @Test
  public void isValid_returnsFalse_whenConsignmentCheckNull() {
    assertFalse(validator.isValid(partTwo, null));
  }


  @Test
  public void isValid_returnsFalse_whenDocumentCheckNullAndPhysicalCheckResultNull() {
    partTwo.setConsignmentCheck(new ConsignmentCheck());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNullAndPhysicalCheckResultNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .physicalCheckResult(NOT_SATISFACTORY)
        .build());

    assertTrue(validator.isValid(partTwo, null));
  }


  @Test
  public void isValid_returnsFalse_whenDocumentCheckSatisfactoryAndPhysicalCheckResultNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(SATISFACTORY)
        .build());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckSatisfactoryAndIdentityCheckNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(SATISFACTORY)
        .physicalCheckResult(NOT_SATISFACTORY)
        .build());

    assertTrue(validator.isValid(partTwo, null));
  }


  @Test
  public void isValid_returnsFalse_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableAndPhysicalCheckResultNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableAndPhysicalCheckResultNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .physicalCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());

    assertTrue(validator.isValid(partTwo, null));
  }


  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndDecisionNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());

    assertTrue(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().build());

    assertTrue(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableFalse() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(false).build());

    assertTrue(validator.isValid(partTwo, null));
  }
}
