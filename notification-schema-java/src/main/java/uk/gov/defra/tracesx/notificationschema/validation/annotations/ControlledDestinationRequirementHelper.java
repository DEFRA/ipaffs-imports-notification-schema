package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_INTERNAL_MARKET;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.ACCEPTABLE_IF_CHANNELED;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum.NON_ACCEPTABLE;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.REDISPATCH;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.REDISPATCHING;
import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableActionEnum.REEXPORT;

import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotificationTypeEnum;

public class ControlledDestinationRequirementHelper {

  private ControlledDestinationRequirementHelper() {}

  public static boolean isControlledDestinationRequired(Decision decision,
      NotificationTypeEnum type) {
    if (decision == null) {
      return false;
    }
    switch (type) {
      case CVEDA:
        return isControlledDestinationRequiredForCveda(decision);
      case CED:
      case CVEDP:
      case CHEDPP:
        return isControlledDestinationRequiredForCedCvedpChedpp(decision);
      default:
        return false;
    }
  }

  private static boolean isControlledDestinationRequiredForCedCvedpChedpp(Decision decision) {
    return isControlledDestinationRequiredForEachType(decision);
  }

  private static boolean isControlledDestinationRequiredForCveda(Decision decision) {
    return isControlledDestinationRequiredForEachType(decision)
        || isDefinitiveImportNotEmptyForInternalMarket(decision);
  }

  private static boolean isControlledDestinationRequiredForEachType(Decision decision) {
    return isNonAcceptableWithActionOtherThanReexportOrReDispatchingOrReDispatch(decision)
        || isChanneled(decision) || isSpecificWarehouse(decision);
  }

  private static boolean isDefinitiveImportNotEmptyForInternalMarket(Decision decision) {
    return ACCEPTABLE_FOR_INTERNAL_MARKET.equals(decision.getDecision())
        && decision.getDefinitiveImportPurpose() != null;
  }

  private static boolean isSpecificWarehouse(Decision decision) {
    return ACCEPTABLE_FOR_SPECIFIC_WAREHOUSE.equals(decision.getDecision());
  }

  private static boolean isChanneled(Decision decision) {
    return ACCEPTABLE_IF_CHANNELED.equals(decision.getDecision());
  }

  private static boolean isNonAcceptableWithActionOtherThanReexportOrReDispatchingOrReDispatch(
      Decision decision) {
    return NON_ACCEPTABLE.equals(decision.getDecision())
        && decision.getNotAcceptableAction() != null && !REEXPORT
        .equals(decision.getNotAcceptableAction()) && !REDISPATCHING
        .equals(decision.getNotAcceptableAction()) && !REDISPATCH
        .equals(decision.getNotAcceptableAction());
  }
}