package uk.gov.defra.tracesx.notificationschema.constants;

public final class ChedTypeVersion {

  private ChedTypeVersion() { }

  // legacy notifications will have this value
  public static final short DEFAULT = 1;

  // CHED-D values
  public static final short SINGLE_JOURNEY_CHED_D = 2;
}
