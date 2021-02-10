package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;

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
  public void isValid_returnsTrue_whenNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void isValid_returnsFalse_whenDecisionNullAndConsignmentCheckNull() {
    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenDecisionNullAndPhysicalCheckResultNull() {
    partTwo.setConsignmentCheck(new ConsignmentCheck());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenDecisionNullAndPhysicalCheckResultNotNull() {
    partTwo.setConsignmentCheck(ConsignmentCheck.builder().physicalCheckResult(NOT_SATISFACTORY).build());

    assertTrue(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenConsignmentAcceptableNullAndConsignmentCheckNull() {
    partTwo.setDecision(new Decision());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenConsignmentAcceptableNullAndPhysicalCheckResultNull() {
    partTwo.setDecision(new Decision());
    partTwo.setConsignmentCheck(new ConsignmentCheck());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenConsignmentAcceptableNullAndPhysicalCheckResultNotNull() {
    partTwo.setDecision(new Decision());
    partTwo.setConsignmentCheck(ConsignmentCheck.builder().physicalCheckResult(NOT_SATISFACTORY).build());

    assertTrue(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenConsignmentAcceptableTrueAndConsignmentCheckNull() {
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsFalse_whenConsignmentAcceptableTrueAndPhysicalCheckResultNull() {
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());
    partTwo.setConsignmentCheck(new ConsignmentCheck());

    assertFalse(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenConsignmentAcceptableTrueAndPhysicalCheckResultNotNull() {
    partTwo.setDecision(Decision.builder().consignmentAcceptable(true).build());
    partTwo.setConsignmentCheck(ConsignmentCheck.builder().physicalCheckResult(NOT_SATISFACTORY).build());

    assertTrue(validator.isValid(partTwo, null));
  }

  @Test
  public void isValid_returnsTrue_whenConsignmentAcceptableFalse() {
    partTwo.setDecision(Decision.builder().consignmentAcceptable(false).build());

    assertTrue(validator.isValid(partTwo, null));
  }
}
