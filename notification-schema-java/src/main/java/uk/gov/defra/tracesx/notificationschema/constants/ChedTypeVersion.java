package uk.gov.defra.tracesx.notificationschema.constants;

public final class ChedTypeVersion {

  private ChedTypeVersion() { }

  // Value for legacy notifications that were created before the ChedTypeVersionRule
  // was added in notification-ms
  public static final short NOT_SET = 0;
  // Default value that can then be overridden when required
  public static final short DEFAULT = 1;

  // CHED-D values
  public static final short SINGLE_JOURNEY_CHED_D = 2;
}
