package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class NotNullKeyDataPairValidation extends ComplementParameterSetKeyDataPairValidator {

  public NotNullKeyDataPairValidation(String fieldName) {
    super(fieldName);
  }

  @Override
  protected boolean isValid(String data) {
    return !isEmpty(data);
  }
}
