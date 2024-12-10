package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableReasonsEnum;

class NotAcceptableEstablishmentValidatorTest {

  private NotAcceptableEstablishmentValidator validator;

  @BeforeEach
  void setUp() {
    validator = new NotAcceptableEstablishmentValidator();
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
  void givenNoNonApprovedEstablishmentName_whenICallIsValid_thenResultIsFalse() {
    Decision decision = new Decision();

    List<NotAcceptableReasonsEnum> notAcceptableReasons = new ArrayList<>();
    notAcceptableReasons.add(NotAcceptableReasonsEnum.IDMISMATCHWITHDOCUMENTS);
    notAcceptableReasons.add(NotAcceptableReasonsEnum.NONAPPROVEDESTABLISHMENT);
    decision.setConsignmentAcceptable(false);
    decision.setNotAcceptableReasons(notAcceptableReasons);

    assertThat(validator.isValid(decision, null)).isFalse();
  }

  @Test
  void givenANonApprovedEstablishmentName_whenICallIsValid_thenResultIsFalse() {
    Decision decision = new Decision();

    List<NotAcceptableReasonsEnum> notAcceptableReasons = new ArrayList<>();
    notAcceptableReasons.add(NotAcceptableReasonsEnum.IDMISMATCHWITHDOCUMENTS);
    notAcceptableReasons.add(NotAcceptableReasonsEnum.NONAPPROVEDESTABLISHMENT);
    decision.setConsignmentAcceptable(false);
    decision.setNotAcceptableReasons(notAcceptableReasons);
    decision.setNotAcceptableEstablishment("Establishment name");

    assertThat(validator.isValid(decision, null)).isTrue();
  }

  @Test
  void givenNonApprovedEstablishmentIsNotANotAcceptableReason_whenICallIsValid_thenResultIsTrue() {
    Decision decision = new Decision();

    List<NotAcceptableReasonsEnum> notAcceptableReasons = new ArrayList<>();
    notAcceptableReasons.add(NotAcceptableReasonsEnum.IDMISMATCHWITHDOCUMENTS);
    decision.setConsignmentAcceptable(false);
    decision.setNotAcceptableReasons(notAcceptableReasons);

    assertThat(validator.isValid(decision, null)).isTrue();
  }
}
