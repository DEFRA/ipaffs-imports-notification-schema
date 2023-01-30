package uk.gov.defra.tracesx.notificationschema.validation.annotations;

public class ChedppNotNullKeyDataPairValidator
    extends CommoditiesComplementParameterSetKeyDataPairValidator<ChedppNotNullKeyDataPair> {

  @Override
  public ComplementParameterSetKeyDataPairValidator initializeValidator(
      ChedppNotNullKeyDataPair constraintAnnotation) {
    return new NotNullKeyDataPairValidation(constraintAnnotation.field());
  }
}
