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

public class ChedpIdentityCheckTest {

  private ChedpIdentityCheckValidator validator;
  private PartTwo partTwo;

  @Before
  public void setUp() {
    validator = new ChedpIdentityCheckValidator();
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
  public void isValid_returnsFalse_whenDocumentCheckNullAndIdentityCheckTypeNull() {
    partTwo.setConsignmentCheck(new ConsignmentCheck());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckNullAndIdentityCheckResultNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .identityCheckType(FULL_IDENTITY_CHECK)
        .build());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNullAndIdentityCheckNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .identityCheckType(FULL_IDENTITY_CHECK)
        .identityCheckResult(NOT_SATISFACTORY)
        .build());

    assertTrue(validator.isValid(partTwo, null));
  }


  @Test
  public void isValid_returnsFalse_whenDocumentCheckSatisfactoryAndIdentityCheckTypeNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(SATISFACTORY)
        .build());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckSatisfactoryAndIdentityCheckResultNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(SATISFACTORY)
        .identityCheckType(FULL_IDENTITY_CHECK)
        .build());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckSatisfactoryAndIdentityCheckNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(SATISFACTORY)
        .identityCheckType(FULL_IDENTITY_CHECK)
        .identityCheckResult(NOT_SATISFACTORY)
        .build());

    assertTrue(validator.isValid(partTwo, null));
  }


  @Test
  public void isValid_returnsFalse_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableAndIdentityCheckTypeNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableAndIdentityCheckResultNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .identityCheckType(FULL_IDENTITY_CHECK)
        .build());
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckNotSatisfactoryAndConsignmentAcceptableAndIdentityCheckNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .documentCheckResult(NOT_SATISFACTORY)
        .identityCheckType(FULL_IDENTITY_CHECK)
        .identityCheckResult(NOT_SATISFACTORY)
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
