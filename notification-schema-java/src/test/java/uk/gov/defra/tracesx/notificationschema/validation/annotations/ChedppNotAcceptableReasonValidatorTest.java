package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.SingleChedppNotAcceptableReason;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ChedppNotAcceptableCommodityOrPackageEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ChedppNotAcceptableReasonEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableReasonsEnum;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ChedppNotAcceptableReasonValidatorTest {

  private ChedppNotAcceptableReasonValidator validator;

  @Before
  public void setUp() {
    validator = new ChedppNotAcceptableReasonValidator();
  }

  @Test
  public void testThatValidatorReturnsTrueIfNullPassed() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfConsignmentAcceptableReturnsNull() {
    Decision decision = new Decision();

    assertTrue(validator.isValid(decision, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfConsignmentAcceptableIsTrue() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.TRUE);

    assertTrue(validator.isValid(decision, null));
  }

  @Test
  public void
  testThatValidatorReturnsFalseIfConsignmentAcceptableIsFalseAndNotAcceptableReasonsIsNull() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);

    assertFalse(validator.isValid(decision, null));
  }

  @Test
  public void
  testThatValidatorReturnsFalseIfConsignmentAcceptableIsFalseAndChedppNotAcceptableReasonsIsEmpty() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);
    decision.setChedppNotAcceptableReasons(new ArrayList<>());

    assertFalse(validator.isValid(decision, null));
  }

  @Test
  public void testThatValidatorReturnsFalseIfConsignmentAcceptableIsFalseAndChedppNotAcceptableReasonIsNull() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);

    List<SingleChedppNotAcceptableReason> reasonList = Collections
        .singletonList(new SingleChedppNotAcceptableReason(
            null, ChedppNotAcceptableCommodityOrPackageEnum.PACKAGE));

    decision.setChedppNotAcceptableReasons(reasonList);

    assertFalse(validator.isValid(decision, null));
  }

  @Test
  public void testThatValidatorReturnsFalseIfConsignmentAcceptableIsFalseAndChedppNotAcceptableCommodityOrPackageIsNull() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);

    List<SingleChedppNotAcceptableReason> reasonList = Collections
        .singletonList(new SingleChedppNotAcceptableReason(
            ChedppNotAcceptableReasonEnum.DOCNCEVD, null));

    decision.setChedppNotAcceptableReasons(reasonList);

    assertFalse(validator.isValid(decision, null));
  }

  @Test
  public void testThatValidatorReturnsTrueIfConsignmentAcceptableIsFalseAndChedppNotAcceptableReasonsAreValid() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);

    List<SingleChedppNotAcceptableReason> reasonList = Collections
        .singletonList(new SingleChedppNotAcceptableReason(
            ChedppNotAcceptableReasonEnum.DOCNCEVD, ChedppNotAcceptableCommodityOrPackageEnum.PACKAGE));

    decision.setChedppNotAcceptableReasons(reasonList);

    assertTrue(validator.isValid(decision, null));
  }
}
