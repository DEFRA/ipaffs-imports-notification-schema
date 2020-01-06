package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SATISFACTORY;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.SATISFACTORY;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

public class DocumentCheckEuStandardValidatorTest {

  private DocumentCheckResultValidator validator;

  @Before
  public void setUp() {
    validator = new DocumentCheckResultValidator();
  }

  @Test
  public void testThatValidatorReturnsTrueIfNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfIsDocumentCheckResultReturnsNull() {
    ConsignmentCheck check = new ConsignmentCheck();

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void testThatValidatorReturnsFalseIfDocumentCheckResultIsNotSet() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setDocumentCheckResult(NOT_SET);

    assertFalse(validator.isValid(check, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfDocumentCheckResultIsSatisfactory() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setDocumentCheckResult(SATISFACTORY);

    assertTrue(validator.isValid(check, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIffDocumentCheckResultIsNotSatisfactory() {
    ConsignmentCheck check = new ConsignmentCheck();
    check.setDocumentCheckResult(NOT_SATISFACTORY);

    assertTrue(validator.isValid(check, null));
  }
}
