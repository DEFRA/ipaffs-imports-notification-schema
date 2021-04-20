package uk.gov.defra.tracesx.notificationschema.validation.annotations;

public class IsPositiveDoubleKeyDataPairValidation extends
    ComplementParameterSetKeyDataPairValidator {

  public IsPositiveDoubleKeyDataPairValidation(String fieldName) {
    super(fieldName);
  }

  @Override
  protected boolean isValid(String data) {
    try {
      return Double.parseDouble(data) > 0;
    } catch (NumberFormatException exception) {
      return false;
    }
  }
}
