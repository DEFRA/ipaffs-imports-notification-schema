package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum;

@RunWith(Theories.class)
public class ControlledDestinationRequirementHelperTest {

  private Decision decision;

  @Before
  public void setUp() {
    decision = Decision.builder().build();
  }

  @Test
  public void isControlledDestinationRequiredForCveda_nonAcceptableOtherAction_isTrue() {
    decision.setDecision(NON_ACCEPTABLE);
    decision.setNotAcceptableAction(OTHER);

    boolean result = ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(decision, CVEDA);

    assertTrue(result);
  }

  @Test
  public void isControlledDestinationRequiredForCveda_nonAcceptableReExportAction_isFalse() {
    decision.setDecision(NON_ACCEPTABLE);
    decision.setNotAcceptableAction(REEXPORT);

    boolean result = ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(decision, CVEDA);

    assertFalse(result);
  }

  @DataPoints("Decisions for CED CVEDP that require controlled destinations")
  public static final Decision[] decisionThatRequireControlledDestinations = new Decision[]{
      Decision.builder().decision(ACCEPTABLE_IF_CHANNELED).build(),
      Decision.builder().decision(ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE).build(),
      Decision.builder().decision(NON_ACCEPTABLE).notAcceptableAction(DESTRUCTION).build(),
      Decision.builder().decision(NON_ACCEPTABLE).notAcceptableAction(OTHER).build(),
      Decision.builder().decision(NON_ACCEPTABLE)
          .notAcceptableAction(NotAcceptableActionEnum.SLAUGHTER).build()
  };

  @Theory
  public void isControlledDestinationRequiredForCedCvedp_decisionsRequiringControlledDestination_isTrue(
      @FromDataPoints("Decisions for CED CVEDP that require controlled destinations")
          Decision decision) {
    boolean result = ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(decision, CVEDP);

    assertTrue(result);
  }

  @DataPoints("Decisions for CED CVEDP that not require controlled destinations")
  public static final Decision[] decisionsThatNotRequireControlledDestination = new Decision[]{
      Decision.builder().decision(NON_ACCEPTABLE).notAcceptableAction(REEXPORT).build(),
      Decision.builder().decision(NON_ACCEPTABLE).build(),
      Decision.builder().decision(ACCEPTABLE_FOR_TEMPORARY_IMPORT).build(),
      Decision.builder().decision(ACCEPTABLE_FOR_TRANSHIPMENT).build(),
      Decision.builder().decision(ACCEPTABLE_FOR_INTERNAL_MARKET).build(),
  };

  @Theory
  public void isControlledDestinationRequiredForCedCvedp_decisionsNotRequiringControlledDestination_isFalse(
      @FromDataPoints("Decisions for CED CVEDP that not require controlled destinations")
          Decision decision) {
    boolean result = ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(decision, CVEDP);

    assertFalse(result);
  }

  @Test
  public void isControlledDestinationRequiredForCveda_internalMarketWithDefinitiveImportPurpose_isTrue() {
    decision.setDecision(ACCEPTABLE_FOR_INTERNAL_MARKET);
    decision.setDefinitiveImportPurpose(APPROVEDBODIES);

    boolean result = ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(decision, CVEDA);

    assertTrue(result);
  }

  @Test
  public void isControlledDestinationRequiredForCedCvedp_decisionNonAcceptableNotAcceptableReDispatching_isFalse() {
    decision.setDecision(NON_ACCEPTABLE);
    decision.setNotAcceptableAction(REDISPATCHING);

    boolean result = ControlledDestinationRequirementHelper
        .isControlledDestinationRequired(decision, CVEDP);

    assertFalse(result);
  }
}
