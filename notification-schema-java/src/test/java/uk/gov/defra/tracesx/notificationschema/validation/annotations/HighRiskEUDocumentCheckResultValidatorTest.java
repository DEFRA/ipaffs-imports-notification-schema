package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

public class HighRiskEUDocumentCheckResultValidatorTest {

  private HighRiskEUDocumentCheckResultValidator validator;

  @Before
  public void setUp() {
    validator = new HighRiskEUDocumentCheckResultValidator();
  }

  @Test
  public void isValid_returnsTrue_whenConsignmentCheckIsNull() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckIsNull() {
    ConsignmentCheck check = new ConsignmentCheck();

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsFalse_whenDocumentCheckIsNotSet() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setDocumentCheckResult(NOT_SET);

    assertFalse(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckResultIsSatisfactoryFollowingOfficialIntervention() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setDocumentCheckResult(SATISFACTORY_FOLLOWING_OFFICIAL_INTERVENTION);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckResultIsSatisfactory() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setDocumentCheckResult(SATISFACTORY);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void isValid_returnsTrue_whenDocumentCheckResultIsNotSatisfactory() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setDocumentCheckResult(NOT_SATISFACTORY);

    assertTrue(validator.isValid(check, null));
  }
}
