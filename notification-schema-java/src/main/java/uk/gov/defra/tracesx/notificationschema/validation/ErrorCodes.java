package uk.gov.defra.tracesx.notificationschema.validation;

public class ErrorCodes {

  public static final String NOT_NULL = "1";
  public static final String GREATER_THAN_ZERO = "2";
  public static final String NUMBER_OF_PACKAGES_MUST_BE_GREATER_THAN_ZERO = "3";
  public static final String NETWEIGHT_MUST_BE_GREATER_THAN_ZERO = "4";
  public static final String NOT_EMPTY = "5";
  public static final String PHYSICAL_CHECK_NO_REASON_SUPPLIED = "6";
  public static final String NOT_ACCEPTABLE_REASONS_NOT_SUPPLIED = "7";
  public static final String NUMBER_OF_ANIMALS_MUST_BE_GREATER_THAN_ZERO = "8";
  public static final String NOT_ACCEPTABLE_ACTION_NOT_SUPPLIED = "9";
  public static final String DOCUMENT_CHECK_RESULT_NOT_SET = "10";

  private ErrorCodes() {
    // no-arg constructor
  }
}
