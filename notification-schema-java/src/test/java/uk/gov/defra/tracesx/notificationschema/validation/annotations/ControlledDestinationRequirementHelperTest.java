package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TEMPORARY_IMPORT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TRANSHIPMENT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_IF_CHANNELED;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.NON_ACCEPTABLE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DefinitiveImportPurposeEnum.APPROVEDBODIES;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.DESTRUCTION;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.OTHER;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.REDISPATCHING;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.REEXPORT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotificationTypeEnum.CVEDA;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotificationTypeEnum.CVEDP;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum;

class ControlledDestinationRequirementHelperTest {

  private Decision decision;

  @BeforeEach
  void setUp() {
    decision = Decision.builder().build();
  }

  @Test
  void isControlledDestinationRequiredForCveda_nonAcceptableOtherAction_isTrue() {
    decision.setDecision(NON_ACCEPTABLE);
    decision.setNotAcceptableAction(OTHER);

    boolean result = ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(decision, CVEDA);

    assertThat(result).isTrue();
  }

  @Test
  void isControlledDestinationRequiredForCveda_nonAcceptableReExportAction_isFalse() {
    decision.setDecision(NON_ACCEPTABLE);
    decision.setNotAcceptableAction(REEXPORT);

    boolean result = ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(decision, CVEDA);

    assertThat(result).isFalse();
  }

  private static Stream<Arguments> decisionsThatRequireControlledDestinations() {
    return Stream.of(
        arguments(Decision.builder().decision(ACCEPTABLE_IF_CHANNELED).build()),
        arguments(Decision.builder().decision(ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE).build()),
        arguments(
            Decision.builder().decision(NON_ACCEPTABLE).notAcceptableAction(DESTRUCTION).build()),
        arguments(Decision.builder().decision(NON_ACCEPTABLE).notAcceptableAction(OTHER).build()),
        arguments(Decision.builder().decision(NON_ACCEPTABLE)
            .notAcceptableAction(NotAcceptableActionEnum.SLAUGHTER).build())
    );
  }

  @ParameterizedTest
  @MethodSource("decisionsThatRequireControlledDestinations")
  void isControlledDestinationRequiredForCedCvedp_decisionsRequiringControlledDestination_isTrue(
      Decision decision) {
    boolean result = ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(decision, CVEDP);

    assertThat(result).isTrue();
  }

  private static Stream<Arguments> decisionsThatNotRequireControlledDestinations() {
    return Stream.of(
        arguments(
            Decision.builder().decision(NON_ACCEPTABLE).notAcceptableAction(REEXPORT).build()),
        arguments(Decision.builder().decision(NON_ACCEPTABLE).build()),
        arguments(Decision.builder().decision(ACCEPTABLE_FOR_TEMPORARY_IMPORT).build()),
        arguments(Decision.builder().decision(ACCEPTABLE_FOR_TRANSHIPMENT).build()),
        arguments(Decision.builder().decision(ACCEPTABLE_FOR_INTERNAL_MARKET).build())
    );
  }

  @ParameterizedTest
  @MethodSource("decisionsThatNotRequireControlledDestinations")
  void isControlledDestinationRequiredForCedCvedp_decisionsNotRequiringControlledDestination_isFalse(
      Decision decision) {
    boolean result = ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(decision, CVEDP);

    assertThat(result).isFalse();
  }

  @Test
  void isControlledDestinationRequiredForCveda_internalMarketWithDefinitiveImportPurpose_isTrue() {
    decision.setDecision(ACCEPTABLE_FOR_INTERNAL_MARKET);
    decision.setDefinitiveImportPurpose(APPROVEDBODIES);

    boolean result = ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(decision, CVEDA);

    assertThat(result).isTrue();
  }

  @Test
  void isControlledDestinationRequiredForCedCvedp_decisionNonAcceptableNotAcceptableReDispatching_isFalse() {
    decision.setDecision(NON_ACCEPTABLE);
    decision.setNotAcceptableAction(REDISPATCHING);

    boolean result = ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(decision, CVEDP);

    assertThat(result).isFalse();
  }
}
