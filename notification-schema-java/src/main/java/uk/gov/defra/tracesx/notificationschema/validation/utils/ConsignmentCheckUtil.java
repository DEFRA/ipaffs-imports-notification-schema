package uk.gov.defra.tracesx.notificationschema.validation.utils;

import static uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result.NOT_SET;

import uk.gov.defra.tracesx.notificationschema.representation.ConsignmentCheck;

public class ConsignmentCheckUtil {

  private ConsignmentCheckUtil() {
  }

  public static boolean isExistingCHEDANotification(ConsignmentCheck consignmentCheck) {
    return (consignmentCheck.getDocumentCheckResult() == NOT_SET
        && (consignmentCheck.getEuStandard() != NOT_SET
        || consignmentCheck.getNationalRequirements() != NOT_SET));
  }
}
