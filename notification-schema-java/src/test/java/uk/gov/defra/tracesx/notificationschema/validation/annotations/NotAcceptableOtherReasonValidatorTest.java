package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableReasonsEnum;

class NotAcceptableOtherReasonValidatorTest {

  private NotAcceptableOtherReasonValidator validator;

  @BeforeEach
  void setUp() {
    validator = new NotAcceptableOtherReasonValidator();
  }

  @Test
  void givenDecisionIsNull_whenICallIsValid_thenResultIsTrue() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void givenConsignmentIsAcceptable_whenICallIsValid_thenResultIsTrue() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(true);

    assertThat(validator.isValid(decision, null)).isTrue();
  }

  @Test
  void givenNoNotAcceptableOtherReason_whenICallIsValid_thenResultIsFalse() {
    Decision decision = new Decision();
    List<NotAcceptableReasonsEnum> notAcceptableReasons = Collections
        .singletonList(NotAcceptableReasonsEnum.OTHER);
    decision.setNotAcceptableReasons(notAcceptableReasons);
    decision.setConsignmentAcceptable(false);

    assertThat(validator.isValid(decision, null)).isFalse();
  }

  @Test
  void givenANotAcceptableOtherReason_whenICallIsValid_thenResultIsTrue() {
    Decision decision = new Decision();

    List<NotAcceptableReasonsEnum> notAcceptableReasons = new ArrayList<>();
    notAcceptableReasons.add(NotAcceptableReasonsEnum.IDMISMATCHWITHDOCUMENTS);
    notAcceptableReasons.add(NotAcceptableReasonsEnum.OTHER);
    decision.setConsignmentAcceptable(false);
    decision.setNotAcceptableReasons(notAcceptableReasons);
    decision.setNotAcceptableOtherReason("Other reason");

    assertThat(validator.isValid(decision, null)).isTrue();
  }
}
