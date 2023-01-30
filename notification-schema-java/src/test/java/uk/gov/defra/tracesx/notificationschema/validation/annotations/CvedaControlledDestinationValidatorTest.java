package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_IF_CHANNELED;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.NON_ACCEPTABLE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DefinitiveImportPurposeEnum.APPROVEDBODIES;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.DESTRUCTION;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.EUTHANASIA;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.REEXPORT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.SLAUGHTER;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.TRANSFORMATION;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.EconomicOperator;
import uk.gov.defra.tracesx.notificationschema.representation.PartTwo;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum;

@RunWith(Theories.class)
public class CvedaControlledDestinationValidatorTest {

  private CvedaControlledDestinationValidator validator;
  private PartTwo partTwo;

  @Before
  public void setUp() {
    this.validator = new CvedaControlledDestinationValidator();
    this.partTwo = PartTwo.builder().decision(Decision.builder().build()).build();
  }

  @Test
  public void isValid_emptyPartTwo_isTrue() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void isValid_partTwoWithEmptyDecision_isTrue() {
    assertTrue(validator.isValid(PartTwo.builder().build(), null));
  }

  @DataPoints("Decisions for ControlledDestinations without subOption")
  public static final DecisionEnum[] decisionsWithoutSubOption = new DecisionEnum[]{
      ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE,
      ACCEPTABLE_IF_CHANNELED
  };

  @DataPoints("Decisions for ControlledDestinations with subOptions")
  public static final DecisionEnum[] decisionsWithSubOption = new DecisionEnum[]{
      NON_ACCEPTABLE,
      ACCEPTABLE_FOR_INTERNAL_MARKET,
  };

  @DataPoints("requiring Controlled Destinations")
  public static final NotAcceptableActionEnum[] notAcceptableActionEnumsRequiringControlledDestinations =
      new NotAcceptableActionEnum[]{
          SLAUGHTER,
          EUTHANASIA,
          TRANSFORMATION,
          DESTRUCTION
      };

  @Theory
  public void isValid_decisionsRequiringControlledDestinationsWithoutControlledDestinations_isFalse(
      @FromDataPoints("Decisions for ControlledDestinations without subOption") DecisionEnum decisionValue) {
    partTwo.getDecision().setDecision(decisionValue);

    boolean result = validator.isValid(partTwo, null);

    assertFalse(result);
  }

  @Theory
  public void isValid_decisionsWithoutSubOptionRequirementAndWithControlledDestination_isTrue(
      @FromDataPoints("Decisions for ControlledDestinations without subOption") DecisionEnum decisionValue) {
    partTwo.getDecision().setDecision(decisionValue);
    partTwo.setControlledDestination(EconomicOperator.builder().build());

    boolean result = validator.isValid(partTwo, null);

    assertTrue(result);
  }

  @Theory
  public void isValid_decisionsRequiringSubOptionsWithoutSubOptionsAndControlledDestinations_isTrue(
      @FromDataPoints("Decisions for ControlledDestinations with subOptions") DecisionEnum decisionValue) {
    partTwo.getDecision().setDecision(decisionValue);

    boolean result = validator.isValid(partTwo, null);

    assertTrue(result);
  }

  @Theory
  public void isValid_nonAcceptedWithNonAcceptableActionsExceptReExportWithoutControlledDestination_isFalse(
      @FromDataPoints("requiring Controlled Destinations") NotAcceptableActionEnum notAcceptableAction) {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(notAcceptableAction);

    boolean result = validator.isValid(partTwo, null);

    assertFalse(result);
  }

  @Theory
  public void isValid_nonAcceptedWithExceptReExportWithControlledDestination_isTrue(
      @FromDataPoints("requiring Controlled Destinations") NotAcceptableActionEnum notAcceptableAction) {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(notAcceptableAction);
    partTwo.setControlledDestination(EconomicOperator.builder().build());

    boolean result = validator.isValid(partTwo, null);

    assertTrue(result);
  }

  @Test
  public void isValid_nonAcceptedWithReExportAndWithoutControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(REEXPORT);

    boolean result = validator.isValid(partTwo, null);

    assertTrue(result);
  }

  @Test
  public void isValid_internalMarketWithoutDefinitiveImportPurposeAndWithoutControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_INTERNAL_MARKET);

    boolean result = validator.isValid(partTwo, null);

    assertTrue(result);
  }

  @Test
  public void isValid_internalMarketWithDefinitiveImportPurposeAndWithoutControlledDestination_isFalse() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_INTERNAL_MARKET);
    partTwo.getDecision().setDefinitiveImportPurpose(APPROVEDBODIES);

    boolean result = validator.isValid(partTwo, null);

    assertFalse(result);
  }

  @Test
  public void isValid_internalMarketWithDefinitiveImportPurposeAndWithControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_INTERNAL_MARKET);
    partTwo.getDecision().setDefinitiveImportPurpose(APPROVEDBODIES);
    partTwo.setControlledDestination(EconomicOperator.builder().build());

    boolean result = validator.isValid(partTwo, null);

    assertTrue(result);
  }
}
