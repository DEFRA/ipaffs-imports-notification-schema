package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.NON_ACCEPTABLE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DefinitiveImportPurposeEnum.APPROVEDBODIES;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.REEXPORT;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.EconomicOperator;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum;

class CvedaControlledDestinationValidatorTest {

  private CvedaControlledDestinationValidator validator;
  private PartTwo partTwo;

  @BeforeEach
  void setUp() {
    this.validator = new CvedaControlledDestinationValidator();
    this.partTwo = PartTwo.builder().decision(Decision.builder().build()).build();
  }

  @Test
  void isValid_emptyPartTwo_isTrue() {
    assertThat(validator.isValid(null, null)).isTrue();
  }

  @Test
  void isValid_partTwoWithEmptyDecision_isTrue() {
    assertThat(validator.isValid(PartTwo.builder().build(), null)).isTrue();
  }

  @ParameterizedTest
  @EnumSource(value = DecisionEnum.class, names = {"ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE", "ACCEPTABLE_IF_CHANNELED"})
  void isValid_decisionsRequiringControlledDestinationsWithoutControlledDestinations_isFalse(
      DecisionEnum decisionValue) {
    partTwo.getDecision().setDecision(decisionValue);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isFalse();
  }

  @ParameterizedTest
  @EnumSource(value = DecisionEnum.class, names = {"ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE", "ACCEPTABLE_IF_CHANNELED"})
  void isValid_decisionsWithoutSubOptionRequirementAndWithControlledDestination_isTrue(
      DecisionEnum decisionValue) {
    partTwo.getDecision().setDecision(decisionValue);
    partTwo.setControlledDestination(EconomicOperator.builder().build());

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isTrue();
  }

  @ParameterizedTest
  @EnumSource(value = DecisionEnum.class, names = {"NON_ACCEPTABLE", "ACCEPTABLE_FOR_INTERNAL_MARKET"})
  void isValid_decisionsRequiringSubOptionsWithoutSubOptionsAndControlledDestinations_isTrue(
      DecisionEnum decisionValue) {
    partTwo.getDecision().setDecision(decisionValue);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isTrue();
  }

  @ParameterizedTest
  @EnumSource(value = NotAcceptableActionEnum.class, names = {"SLAUGHTER", "EUTHANASIA", "TRANSFORMATION", "DESTRUCTION"})
  void isValid_nonAcceptedWithNonAcceptableActionsExceptReExportWithoutControlledDestination_isFalse(
      NotAcceptableActionEnum notAcceptableAction) {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(notAcceptableAction);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isFalse();
  }

  @ParameterizedTest
  @EnumSource(value = NotAcceptableActionEnum.class, names = {"SLAUGHTER", "EUTHANASIA", "TRANSFORMATION", "DESTRUCTION"})
  void isValid_nonAcceptedWithExceptReExportWithControlledDestination_isTrue(
      NotAcceptableActionEnum notAcceptableAction) {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(notAcceptableAction);
    partTwo.setControlledDestination(EconomicOperator.builder().build());

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isTrue();
  }

  @Test
  void isValid_nonAcceptedWithReExportAndWithoutControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(REEXPORT);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isTrue();
  }

  @Test
  void isValid_internalMarketWithoutDefinitiveImportPurposeAndWithoutControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_INTERNAL_MARKET);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isTrue();
  }

  @Test
  void isValid_internalMarketWithDefinitiveImportPurposeAndWithoutControlledDestination_isFalse() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_INTERNAL_MARKET);
    partTwo.getDecision().setDefinitiveImportPurpose(APPROVEDBODIES);

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isFalse();
  }

  @Test
  void isValid_internalMarketWithDefinitiveImportPurposeAndWithControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_INTERNAL_MARKET);
    partTwo.getDecision().setDefinitiveImportPurpose(APPROVEDBODIES);
    partTwo.setControlledDestination(EconomicOperator.builder().build());

    boolean result = validator.isValid(partTwo, null);

    assertThat(result).isTrue();
  }
}
