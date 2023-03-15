package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.PartOne;

public class NotNullCustomsReferenceNumberValidatorTest {

  private PartOne partOne;
  private NotNullCustomsReferenceNumberValidator validator;

  @Before
  public void setUp() {
    partOne = new PartOne();
    validator = new NotNullCustomsReferenceNumberValidator();
  }

  @Test
  public void validatorReturnsFalse_ifNoPartOne() {
    assertFalse(validator.isValid(null, null));
  }

  @Test
  public void validatorReturnsFalse_ifNoCustomsReferenceNumber() {
    assertFalse(validator.isValid(partOne, null));
  }

  @Test
  public void validatorReturnsTrue_ifCustomsReferenceNumber() {
    partOne.setCustomsReferenceNumber("ABCD1234");

    assertTrue(validator.isValid(partOne, null));
  }

  @Test
  public void validatorReturnsFalse_ifEmptyCustomsReferenceNumber() {
    partOne.setCustomsReferenceNumber("");

    assertFalse(validator.isValid(partOne, null));
  }
}
