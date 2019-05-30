package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.NotAcceptableReasonsEnum;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static java.lang.Boolean.FALSE;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class NotAcceptableCountryValidator
    implements ConstraintValidator<NotAcceptableCountry, Decision> {

  @Override
  public void initialize(NotAcceptableCountry constraintAnnotation) {
    // no action
  }

  @Override
  public boolean isValid(Decision decision, ConstraintValidatorContext context) {
    if (decision == null) {
      return true;
    }
    if (FALSE.equals(decision.getConsignmentAcceptable())
        && decision.getNotAcceptableReasons() != null
        && !decision.getNotAcceptableReasons().isEmpty()) {

      for (NotAcceptableReasonsEnum notAcceptableReasons : decision.getNotAcceptableReasons()) {
        if (notAcceptableReasons == NotAcceptableReasonsEnum.NONAPPROVEDCOUNTRY) {
          return isNotEmpty(decision.getNotAcceptableCountry());
        }
      }
    }
    return true;
  }
}
