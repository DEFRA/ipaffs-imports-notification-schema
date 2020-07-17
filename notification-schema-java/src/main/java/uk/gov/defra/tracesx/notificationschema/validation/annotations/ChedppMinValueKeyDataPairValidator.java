package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;

public class ChedppMinValueKeyDataPairValidator
    extends CommoditiesComplementParameterSetKeyDataPairValidator<ChedppMinValueKeyDataPair> {

  @Override
  public ComplementParameterSetKeyDataPairValidator initializeValidator(
      ChedppMinValueKeyDataPair constraintAnnotation) {
    return new MinValueKeyDataPairValidation(constraintAnnotation.field());
  }

  @Override
  protected boolean isKeyDataPairValid(ComplementParameterSet complementParameterSet) {
    if (complementParameterSet.getKeyDataPair() == null) {
      return true;
    }
    return super.isKeyDataPairValid(complementParameterSet);
  }
}
