package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableReasonsEnum;

public class NotAcceptableOtherReasonValidatorTest {

  private NotAcceptableOtherReasonValidator validator;

  @Before
  public void setUp() {
    validator = new NotAcceptableOtherReasonValidator();
  }

  @Test
  public void givenDecisionIsNull_whenICallIsValid_thenResultIsTrue() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void givenConsignmentIsAcceptable_whenICallIsValid_thenResultIsTrue() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(true);

    assertTrue(validator.isValid(decision, null));
  }

  @Test
  public void givenNoNotAcceptableOtherReason_whenICallIsValid_thenResultIsFalse() {
    Decision decision = new Decision();
    List<NotAcceptableReasonsEnum> notAcceptableReasons = Collections
        .singletonList(NotAcceptableReasonsEnum.OTHER);
    decision.setNotAcceptableReasons(notAcceptableReasons);
    decision.setConsignmentAcceptable(false);

    assertFalse(validator.isValid(decision, null));
  }

  @Test
  public void givenANotAcceptableOtherReason_whenICallIsValid_thenResultIsTrue() {
    Decision decision = new Decision();

    List<NotAcceptableReasonsEnum> notAcceptableReasons = new ArrayList<>();
    notAcceptableReasons.add(NotAcceptableReasonsEnum.IDMISMATCHWITHDOCUMENTS);
    notAcceptableReasons.add(NotAcceptableReasonsEnum.OTHER);
    decision.setConsignmentAcceptable(false);
    decision.setNotAcceptableReasons(notAcceptableReasons);
    decision.setNotAcceptableOtherReason("Other reason");

    assertTrue(validator.isValid(decision, null));
  }
}
