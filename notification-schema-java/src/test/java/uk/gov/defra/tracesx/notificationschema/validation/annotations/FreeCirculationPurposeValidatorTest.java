package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.FreeCirculationPurposeEnum;

class FreeCirculationPurposeValidatorTest {

  private FreeCirculationPurposeValidator validator;

  @BeforeEach
  void setUp() {
    validator = new FreeCirculationPurposeValidator();
  }

  @Test
  void isValid_acceptableForInternalMarketWithoutDecision_isTrue() {
    Decision decision = new Decision();

    boolean result = validator.isValid(decision, null);

    assertThat(result).isTrue();
  }

  @Test
  void isValid_acceptableForInternalMarketWithoutFreeCirculationPurpose_isFalse() {
    Decision decision = Decision.builder().decision(ACCEPTABLE_FOR_INTERNAL_MARKET).build();

    boolean result = validator.isValid(decision, null);

    assertThat(result).isFalse();
  }

  @ParameterizedTest
  @EnumSource(value = FreeCirculationPurposeEnum.class, names = {"ANIMAL_FEEDING_STUFF", "HUMAN_CONSUMPTION", "FURTHER_PROCESS", "OTHER"})
  void isValid_acceptableForInternalMarketWithFreeCirculationPurpose_isTrue(
    FreeCirculationPurposeEnum purposeValue) {
    Decision decision = Decision.builder().decision(ACCEPTABLE_FOR_INTERNAL_MARKET)
        .freeCirculationPurpose(purposeValue).build();

    boolean result = validator.isValid(decision, null);

    assertThat(result).isTrue();
  }

  @ParameterizedTest
  @EnumSource(value = DecisionEnum.class, names = {"NON_ACCEPTABLE", "ACCEPTABLE_FOR_TRANSHIPMENT"})
  void isValid_otherDecisions_isTrue(DecisionEnum decisionValue) {
    Decision decision = Decision.builder().decision(decisionValue).build();

    boolean result = validator.isValid(decision, null);

    assertThat(result).isTrue();
  }
}
