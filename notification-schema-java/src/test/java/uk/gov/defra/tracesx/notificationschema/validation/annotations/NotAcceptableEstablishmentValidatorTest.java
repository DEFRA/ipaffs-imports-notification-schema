package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.FreeCirculationPurposeEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableReasonsEnum;

import java.util.ArrayList;
import java.util.List;

public class NotAcceptableEstablishmentValidatorTest {

  private NotAcceptableEstablishmentValidator validator;

  @Before
  public void setUp() {
    validator = new NotAcceptableEstablishmentValidator();
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
  public void givenNoNonApprovedEstablishmentName_whenICallIsValid_thenResultIsFalse() {
    Decision decision = new Decision();

    List<NotAcceptableReasonsEnum> notAcceptableReasons = new ArrayList<>();
    notAcceptableReasons.add(NotAcceptableReasonsEnum.IDMISMATCHWITHDOCUMENTS);
    notAcceptableReasons.add(NotAcceptableReasonsEnum.NONAPPROVEDESTABLISHMENT);
    decision.setConsignmentAcceptable(false);
    decision.setNotAcceptableReasons(notAcceptableReasons);

    assertFalse(validator.isValid(decision, null));
  }

  @Test
  public void givenANonApprovedEstablishmentName_whenICallIsValid_thenResultIsFalse() {
    Decision decision = new Decision();

    List<NotAcceptableReasonsEnum> notAcceptableReasons = new ArrayList<>();
    notAcceptableReasons.add(NotAcceptableReasonsEnum.IDMISMATCHWITHDOCUMENTS);
    notAcceptableReasons.add(NotAcceptableReasonsEnum.NONAPPROVEDESTABLISHMENT);
    decision.setConsignmentAcceptable(false);
    decision.setNotAcceptableReasons(notAcceptableReasons);
    decision.setNotAcceptableEstablishment("Establishment name");

    assertTrue(validator.isValid(decision, null));
  }

  @Test
  public void givenNonApprovedEstablishmentIsNotANotAcceptableReason_whenICallIsValid_thenResultIsTrue() {
    Decision decision = new Decision();

    List<NotAcceptableReasonsEnum> notAcceptableReasons = new ArrayList<>();
    notAcceptableReasons.add(NotAcceptableReasonsEnum.IDMISMATCHWITHDOCUMENTS);
    decision.setConsignmentAcceptable(false);
    decision.setNotAcceptableReasons(notAcceptableReasons);

    assertTrue(validator.isValid(decision, null));
  }
}
