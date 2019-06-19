package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_TRANSIT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_IF_CHANNELED;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.NON_ACCEPTABLE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.DESTRUCTION;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.OTHER;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.REDISPATCHING;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.REEXPORT;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.SLAUGHTER;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.SpecificWarehouseNonConformingConsignmentEnum.CUSTOMWAREHOUSE;

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
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DefinitiveImportPurposeEnum;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum;

@RunWith(Theories.class)
public class CedOrCvedpControlledDestinationValidatorTest {

  private CedOrCvedpControlledDestinationValidator validator;

  @DataPoints("requiring Controlled Destination")
  public static NotAcceptableActionEnum[] notAcceptableActions = new NotAcceptableActionEnum[]{
      DESTRUCTION,
      SLAUGHTER,
      OTHER
  };
  private PartTwo partTwo;

  @Before
  public void setUp() {
    this.validator = new CedOrCvedpControlledDestinationValidator();
    this.partTwo = PartTwo.builder().decision(Decision.builder().build()).build();
  }

  @Test
  public void isValidForNullPartTwo() {
    assertTrue(validator.isValid(null, null));
  }

  @Test
  public void isValidForNullDecision() {
    assertTrue(validator.isValid(PartTwo.builder().build(), null));
  }

  @Test
  public void isValid_DecisionTransferWithoutControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_TRANSIT);

    boolean result = validator
        .isValid(partTwo, null);

    assertTrue(result);
  }

  @Theory
  public void isValid_notAcceptableWithFilledControlledDestination_isTrue(
      @FromDataPoints("requiring Controlled Destination") NotAcceptableActionEnum notAcceptableAction) {
    partTwo.setControlledDestination(EconomicOperator.builder().build());
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(notAcceptableAction);

    boolean result = validator.isValid(partTwo, null);

    assertTrue(result);
  }

  @Theory
  public void isValid_notAcceptableWithoutFilledControlledDestination_isFalse(
      @FromDataPoints("requiring Controlled Destination") NotAcceptableActionEnum notAcceptableAction) {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(notAcceptableAction);

    boolean result = validator.isValid(partTwo, null);

    assertFalse(result);
  }

  @Test
  public void isValid_nonAcceptableWithReExportWithoutControlledDestination_isTrue() {
    partTwo.setControlledDestination(EconomicOperator.builder().build());
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(REEXPORT);

    boolean result = validator.isValid(partTwo, null);

    assertTrue(result);
  }

  @Test
  public void isValid_nonAcceptableWithoutNotAcceptableActionAndWithoutControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);

    boolean result = validator.isValid(partTwo, null);

    assertTrue(result);
  }

  @Test
  public void isValid_nonAcceptableWithDestructionWithoutControlledDestination_isFalse() {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(DESTRUCTION);

    boolean result = validator.isValid(partTwo, null);

    assertFalse(result);
  }

  @Test
  public void isValid_acceptableForInternalMarketSlaughterWithoutControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_INTERNAL_MARKET);
    partTwo.getDecision().setDefinitiveImportPurpose(DefinitiveImportPurposeEnum.SLAUGHTER);

    boolean result = validator.isValid(partTwo, null);

    assertTrue(result);
  }

  @Test
  public void isValid_channeledWithoutControlledDestination_isFalse() {
    partTwo.getDecision().setDecision(ACCEPTABLE_IF_CHANNELED);

    boolean valid = validator.isValid(partTwo, null);

    assertFalse(valid);
  }

  @Test
  public void isValid_specificWarehouseAndSpecificWarehouseNonConformingConsignmentWithoutControlledDestination_isFalse() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE);
    partTwo.getDecision().setSpecificWarehouseNonConformingConsignment(CUSTOMWAREHOUSE);

    boolean result = validator.isValid(partTwo, null);

    assertFalse(result);
  }

  @Test
  public void isValid_specificWarehouseAndSpecificWarehouseNonConformingConsignmentWithControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE);
    partTwo.getDecision().setSpecificWarehouseNonConformingConsignment(CUSTOMWAREHOUSE);
    partTwo.setControlledDestination(EconomicOperator.builder().build());

    boolean result = validator.isValid(partTwo, null);

    assertTrue(result);
  }

  @Test
  public void isValid_nonAcceptableReDispatchingWithoutControlledDestination_isTrue() {
    partTwo.getDecision().setDecision(NON_ACCEPTABLE);
    partTwo.getDecision().setNotAcceptableAction(REDISPATCHING);
    partTwo.setControlledDestination(null);

    boolean result = validator.isValid(partTwo, null);

    assertTrue(result);
  }
}