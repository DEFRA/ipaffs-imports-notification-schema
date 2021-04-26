package uk.gov.defra.tracesx.notificationschema.validation.annotations;

public class ChedppIsPositiveDoubleKeyDataPairValidator
    extends
    CommoditiesComplementParameterSetKeyDataPairValidator<ChedppIsPositiveDoubleKeyDataPair> {

  @Override
  public ComplementParameterSetKeyDataPairValidator initializeValidator(
      ChedppIsPositiveDoubleKeyDataPair constraintAnnotation) {
    return new IsPositiveDoubleKeyDataPairValidation(constraintAnnotation.field());
  }
}
