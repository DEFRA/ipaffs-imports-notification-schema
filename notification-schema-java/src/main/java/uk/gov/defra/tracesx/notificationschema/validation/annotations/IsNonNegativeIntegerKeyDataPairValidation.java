package uk.gov.defra.tracesx.notificationschema.validation.annotations;

public class IsNonNegativeIntegerKeyDataPairValidation extends
    ComplementParameterSetKeyDataPairValidator {

  public IsNonNegativeIntegerKeyDataPairValidation(String fieldName) {
    super(fieldName);
  }

  @Override
  protected boolean isValid(String data) {
    try {
      return Integer.parseInt(data) >= 0;
    } catch (NumberFormatException exception) {
      return false;
    }
  }
}
