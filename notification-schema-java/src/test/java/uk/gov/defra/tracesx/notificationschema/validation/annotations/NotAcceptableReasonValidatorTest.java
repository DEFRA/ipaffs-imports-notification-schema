package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableReasonsEnum;

class NotAcceptableReasonValidatorTest {

  private NotAcceptableReasonValidator validator;

  @BeforeEach
  void setUp() {
    validator = new NotAcceptableReasonValidator();
  }

  @Test
  void testThatValidatorReturnsTrueIfNullPassed() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueIfConsignmentAcceptableReturnsNull() {
    Decision decision = new Decision();

    assertThat(validator.isValid(decision, null)).isTrue();
  }

  @Test
  void testThatValidatorReturnsTrueIfConsignmentAcceptableIsTrue() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.TRUE);

    assertThat(validator.isValid(decision, null)).isTrue();
  }

  @Test
  void
  testThatValidatorReturnsFalseIfConsignmentAcceptableIsFalseAndNotAcceptableReasonsIsNull() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);

    assertThat(validator.isValid(decision, null)).isFalse();
  }

  @Test
  void
  testThatValidatorReturnsFalseIfConsignmentAcceptableIsFalseAndNotAcceptableReasonsIsEmpty() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);
    decision.setNotAcceptableReasons(new ArrayList<>());

    assertThat(validator.isValid(decision, null)).isFalse();
  }

  @Test
  void
  testThatValidatorReturnsTrueIfConsignmentAcceptableIsFalseAndNotAcceptableReasonsIsNotEmpty() {
    Decision decision = new Decision();
    decision.setConsignmentAcceptable(Boolean.FALSE);
    List<NotAcceptableReasonsEnum> reasons = new ArrayList<>();
    reasons.add(NotAcceptableReasonsEnum.ABSENCEADDITIONALGUARANTEES);
    decision.setNotAcceptableReasons(reasons);

    assertThat(validator.isValid(decision, null)).isTrue();
  }
}
