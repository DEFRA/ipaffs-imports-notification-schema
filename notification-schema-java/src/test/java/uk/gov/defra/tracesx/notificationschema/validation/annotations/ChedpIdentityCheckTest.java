package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IdentificationCheckType.FULL_IDENTITY_CHECK;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;

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
  public void isValid_returnsTrue_whenNullPassed() {
    assertTrue(validator.isValid(null, null));
  }


  @Test
  public void isValid_returnsFalse_whenDecisionNullAndConsignmentCheckNull() {
    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenDecisionNullAndIdentityCheckTypeNull() {
    partTwo.setConsignmentCheck(new ConsignmentCheck());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenDecisionNullAndIdentityCheckResultNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .identityCheckType(FULL_IDENTITY_CHECK)
        .build());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenDecisionNullAndIdentityCheckResultNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .identityCheckType(FULL_IDENTITY_CHECK)
        .identityCheckResult(NOT_SATISFACTORY)
        .build());

    assertTrue(validator.isValid(partTwo, null));
  }


  @Test
  public void isValid_returnsFalse_whenConsignmentAcceptableNullAndConsignmentCheckNull() {
    partTwo.setDecision(new Decision());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenConsignmentAcceptableNullAndIdentityCheckTypeNull() {
    partTwo.setDecision(new Decision());
    partTwo.setConsignmentCheck(new ConsignmentCheck());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenConsignmentAcceptableNullAndIdentityCheckResultNull() {
    partTwo.setDecision(new Decision());
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .identityCheckType(FULL_IDENTITY_CHECK)
        .build());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenConsignmentAcceptableNullAndIdentityCheckResultNotNull() {
    partTwo.setDecision(new Decision());
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .identityCheckType(FULL_IDENTITY_CHECK)
        .identityCheckResult(NOT_SATISFACTORY)
        .build());

    assertTrue(validator.isValid(partTwo, null));
  }


  @Test
  public void isValid_returnsFalse_whenConsignmentAcceptableTrueAndConsignmentCheckNull() {
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenConsignmentAcceptableTrueAndIdentityCheckTypeNull() {
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());
    partTwo.setConsignmentCheck(new ConsignmentCheck());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenConsignmentAcceptableTrueAndIdentityCheckResultNull() {
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .identityCheckType(FULL_IDENTITY_CHECK)
        .build());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenConsignmentAcceptableTrueAndIdentityCheckResultNotNull() {
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());
    partTwo.setConsignmentCheck(ConsignmentCheck.builder()
        .identityCheckType(FULL_IDENTITY_CHECK)
        .identityCheckResult(NOT_SATISFACTORY)
        .build());

    assertTrue(validator.isValid(partTwo, null));
  }


  @Test
  public void isValid_returnsTrue_whenConsignmentAcceptableFalse() {
    partTwo.setDecision(Decision.builder().consignmentAcceptable(false).build());

    assertTrue(validator.isValid(partTwo, null));
  }
}
