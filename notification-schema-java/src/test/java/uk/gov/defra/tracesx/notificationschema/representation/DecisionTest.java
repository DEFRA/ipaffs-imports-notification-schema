package uk.gov.defra.tracesx.notificationschema.representation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionReasonEnum;

class DecisionTest {

  @Test
  void notAcceptableActionDestructionReasonIsSetCorrectly() {
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

    assertThat(decision.getNotAcceptableActionDestructionReason()).isEqualTo(
        NotAcceptableActionReasonEnum.CONTAMINATED_PRODUCTS);
    assertThat(decision.getNotAcceptableActionEntryRefusalReason()).isEqualTo(
        NotAcceptableActionReasonEnum.PACKAGING_MATERIAL);
    assertThat(decision.getNotAcceptableActionQuarantineImposedReason()).isEqualTo(
        NotAcceptableActionReasonEnum.THE_INTERCEPTED_PART_OF_THE_CONSIGNMENT);
    assertThat(decision.getNotAcceptableActionSpecialTreatmentReason()).isEqualTo(
        NotAcceptableActionReasonEnum.OTHER);
    assertThat(decision.getNotAcceptableActionIndustrialProcessingReason()).isEqualTo(
        NotAcceptableActionReasonEnum.CONTAMINATED_PRODUCTS);
    assertThat(decision.getNotAcceptableActionReDispatchReason()).isEqualTo(
        NotAcceptableActionReasonEnum.MEANS_OF_TRANSPORT);
    assertThat(decision.getNotAcceptableActionUseForOtherPurposesReason()).isEqualTo(
        NotAcceptableActionReasonEnum.OTHER);
  }
}
