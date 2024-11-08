package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.IfChanneledOptionEnum.ARTICLE8;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;

class IfChanneledOptionValidatorTest {

  private IfChanneledOptionValidator validator;

  @BeforeEach
  void setUp() {
    validator = new IfChanneledOptionValidator();
  }

  @Test
  void isValid_acceptableIfChanneledWithoutIfChanneledOption_isFalse() {
    Decision decision = Decision.builder().decision(DecisionEnum.ACCEPTABLE_IF_CHANNELED).build();

    boolean result = validator.isValid(decision, null);

    assertThat(result).isFalse();
  }

  @Test
  void isValid_acceptableIfChanneledWithIfChanneledOption_isTrue() {
    Decision decision = Decision.builder().decision(DecisionEnum.ACCEPTABLE_IF_CHANNELED)
        .ifChanneledOption(
            ARTICLE8).build();

    boolean result = validator.isValid(decision, null);

    assertThat(result).isTrue();
  }

  @ParameterizedTest
  @EnumSource(value = DecisionEnum.class, names = {"ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE", "ACCEPTABLE_FOR_INTERNAL_MARKET", "ACCEPTABLE_FOR_TEMPORARY_IMPORT", "ACCEPTABLE_FOR_TRANSHIPMENT", "ACCEPTABLE_FOR_TRANSIT", "NON_ACCEPTABLE"})
  void isValid_otherDecisions_isTrue(DecisionEnum decisionValue) {
    Decision decision = Decision.builder().decision(decisionValue).build();

    boolean result = validator.isValid(decision, null);

    assertThat(result).isTrue();
  }
}
