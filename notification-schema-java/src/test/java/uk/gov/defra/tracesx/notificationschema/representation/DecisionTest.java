package uk.gov.defra.tracesx.notificationschema.representation;

import static junit.framework.TestCase.assertEquals;
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

    assertEquals(decision.getNotAcceptableActionDestructionReason(),
            NotAcceptableActionReasonEnum.CONTAMINATED_PRODUCTS);
    assertEquals(decision.getNotAcceptableActionEntryRefusalReason(),
            NotAcceptableActionReasonEnum.PACKAGING_MATERIAL);
    assertEquals(decision.getNotAcceptableActionQuarantineImposedReason(),
            NotAcceptableActionReasonEnum.THE_INTERCEPTED_PART_OF_THE_CONSIGNMENT);
    assertEquals(decision.getNotAcceptableActionSpecialTreatmentReason(),
            NotAcceptableActionReasonEnum.OTHER);
    assertEquals(decision.getNotAcceptableActionIndustrialProcessingReason(),
            NotAcceptableActionReasonEnum.CONTAMINATED_PRODUCTS);
    assertEquals(decision.getNotAcceptableActionReDispatchReason(),
            NotAcceptableActionReasonEnum.MEANS_OF_TRANSPORT);
    assertEquals(decision.getNotAcceptableActionUseForOtherPurposesReason(),
            NotAcceptableActionReasonEnum.OTHER);
  }
}
