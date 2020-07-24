package uk.gov.defra.tracesx.notificationschema.representation;

import static junit.framework.TestCase.assertTrue;

import org.junit.Test;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionReasonEnum;

public class DecisionTest {

  @Test
  public void notAcceptableActionDestructionReasonIsSetCorrectly() {
    Decision decision = Decision.builder()
        .notAcceptableActionDestructionReason(NotAcceptableActionReasonEnum.CONTAMINATED_PRODUCTS)
        .notAcceptableActionEntryRefusalReason(NotAcceptableActionReasonEnum.PACKAGING_MATERIAL)
        .notAcceptableActionQuarantineImposedReason(
            NotAcceptableActionReasonEnum.THE_INTERCEPTED_PART_OF_THE_CONSIGNMENT)
        .notAcceptableActionSpecialTreatmentReason(NotAcceptableActionReasonEnum.OTHER)
        .notAcceptableActionIndustrialProcessingReason(
            NotAcceptableActionReasonEnum.CONTAMINATED_PRODUCTS)
        .notAcceptableActionReDispatchReason(NotAcceptableActionReasonEnum.MEANS_OF_TRANSPORT)
        .notAcceptableActionUseForOtherPurposesReason(NotAcceptableActionReasonEnum.OTHER)
        .build();

    assertTrue(decision.getNotAcceptableActionDestructionReason()
        .equals(NotAcceptableActionReasonEnum.CONTAMINATED_PRODUCTS));
    assertTrue(decision.getNotAcceptableActionEntryRefusalReason()
        .equals(NotAcceptableActionReasonEnum.PACKAGING_MATERIAL));
    assertTrue(decision.getNotAcceptableActionQuarantineImposedReason()
        .equals(NotAcceptableActionReasonEnum.THE_INTERCEPTED_PART_OF_THE_CONSIGNMENT));
    assertTrue(decision.getNotAcceptableActionSpecialTreatmentReason()
        .equals(NotAcceptableActionReasonEnum.OTHER));
    assertTrue(decision.getNotAcceptableActionIndustrialProcessingReason()
        .equals(NotAcceptableActionReasonEnum.CONTAMINATED_PRODUCTS));
    assertTrue(decision.getNotAcceptableActionReDispatchReason()
        .equals(NotAcceptableActionReasonEnum.MEANS_OF_TRANSPORT));
    assertTrue(decision.getNotAcceptableActionUseForOtherPurposesReason()
        .equals(NotAcceptableActionReasonEnum.OTHER));
  }
}
