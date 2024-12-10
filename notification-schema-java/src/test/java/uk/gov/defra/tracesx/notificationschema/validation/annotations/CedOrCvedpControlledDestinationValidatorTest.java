package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TRANSIT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_IF_CHANNELED;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.NON_ACCEPTABLE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.DESTRUCTION;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.REDISPATCHING;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.REEXPORT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.SpecificWarehouseNonConformingConsignmentEnum.CUSTOMWAREHOUSE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.EconomicOperator;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DefinitiveImportPurposeEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum;

 class CedOrCvedpControlledDestinationValidatorTest {

  private CedOrCvedpControlledDestinationValidator validator;

  private PartTwo partTwo;

  @BeforeEach
  void setUp() {
    this.validator = new CedOrCvedpControlledDestinationValidator();
    this.partTwo = PartTwo.builder().decision(Decision.builder().build()).build();
  }

  @Test
  void isValidForNullPartTwo() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void isValidForNullDecision() {
    assertThat(validator.isValid(PartTwo.builder().build(), null)).isTrue();
  }

  @Test
  void isValid_DecisionTransferWithoutControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_TRANSIT);

    boolean result = validator
        .isValid(partTwo, null);

    assertThat(result).isTrue();
  }

  @ParameterizedTest
  @EnumSource(value = NotAcceptableActionEnum.class, names = {"DESTRUCTION", "SLAUGHTER", "OTHER"})
  void isValid_notAcceptableWithFilledControlledDestination_isTrue(
      NotAcceptableActionEnum notAcceptableAction) {
    partTwo.setControlledDestination(EconomicOperator.builder().build());
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(notAcceptableAction);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isTrue();
  }

  @ParameterizedTest
  @EnumSource(value = NotAcceptableActionEnum.class, names = {"DESTRUCTION", "SLAUGHTER", "OTHER"})
  void isValid_notAcceptableWithoutFilledControlledDestination_isFalse(
      NotAcceptableActionEnum notAcceptableAction) {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(notAcceptableAction);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isFalse();
  }

  @Test
  void isValid_nonAcceptableWithReExportWithoutControlledDestination_isTrue() {
    partTwo.setControlledDestination(EconomicOperator.builder().build());
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(REEXPORT);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isTrue();
  }

  @Test
  void isValid_nonAcceptableWithoutNotAcceptableActionAndWithoutControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isTrue();
  }

  @Test
  void isValid_nonAcceptableWithDestructionWithoutControlledDestination_isFalse() {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(DESTRUCTION);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isFalse();
  }

  @Test
  void isValid_acceptableForInternalMarketSlaughterWithoutControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_INTERNAL_MARKET);
    partTwo.getDecision().setDefinitiveImportPurpose(DefinitiveImportPurposeEnum.SLAUGHTER);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isTrue();
  }

  @Test
  void isValid_channeledWithoutControlledDestination_isFalse() {
    partTwo.getDecision().setDecision(ACCEPTABLE_IF_CHANNELED);

    boolean valid = validator.isValid(partTwo, null);

    assertThat(valid).isFalse();
  }

  @Test
  void isValid_specificWarehouseAndSpecificWarehouseNonConformingConsignmentWithoutControlledDestination_isFalse() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE);
    partTwo.getDecision().setSpecificWarehouseNonConformingConsignment(CUSTOMWAREHOUSE);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isFalse();
  }

  @Test
  void isValid_specificWarehouseAndSpecificWarehouseNonConformingConsignmentWithControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE);
    partTwo.getDecision().setSpecificWarehouseNonConformingConsignment(CUSTOMWAREHOUSE);
    partTwo.setControlledDestination(EconomicOperator.builder().build());

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isTrue();
  }

  @Test
  void isValid_nonAcceptableReDispatchingWithoutControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(REDISPATCHING);
    partTwo.setControlledDestination(null);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isTrue();
  }
}
