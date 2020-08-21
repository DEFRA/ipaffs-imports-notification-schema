package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

public class EuStandardValidatorImplTest {

  private EuStandardValidatorImpl validator;

  @Before
  public void setUp() {
    validator = new EuStandardValidatorImpl();
  }

  @Test
  public void givenEuStandardIsSatisfactory_whenICallIsValid_thenResultIsTrue() {
    ConsignmentCheck consignmentCheck = new ConsignmentCheck();
    consignmentCheck.setEuStandard(Result.SATISFACTORY);

    assertTrue(validator.isValid(consignmentCheck, null));
  }

  @Test
  public void givenEuStandardIsNotSet_whenICallIsValid_thenResultIsFalse() {
    ConsignmentCheck consignmentCheck = new ConsignmentCheck();
    consignmentCheck.setEuStandard(Result.NOT_SET);

    assertFalse(validator.isValid(consignmentCheck, null));
  }
}
