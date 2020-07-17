package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import java.math.BigDecimal;
import java.util.Optional;

public class MinValueKeyDataPairValidation extends ComplementParameterSetKeyDataPairValidator {

  public MinValueKeyDataPairValidation(String fieldName) {
    super(fieldName);
  }

  @Override
  protected boolean isValid(String data) {
    try {
      BigDecimal decimalValue =
          Optional.ofNullable(data)
              .map(BigDecimal::new)
              .orElseThrow(NumberFormatException::new);
      return decimalValue.compareTo(BigDecimal.ZERO) > 0;
    } catch (NumberFormatException exception) {
      return false;
    }
  }
}
