package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;
import uk.gov.defra.tracesx.notificationschema.validation.utils.HibernateContextUtils;

public class NotNullTransitDestinationThirdCountryValidator implements
    ConstraintValidator<NotNullTransitDestinationThirdCountry, Decision> {

  @Override
  public void initialize(NotNullTransitDestinationThirdCountry constraintAnnotation) {
    // No action
  }

  @Override
  public boolean isValid(Decision decision, ConstraintValidatorContext context) {
    boolean isValid = true;
    if (decision != null && decision.getDecision() != null
        && DecisionEnum.ACCEPTABLE_FOR_TRANSIT.equals(decision.getDecision())) {
      isValid = StringUtils.isNotBlank(decision.getTransitDestinationThirdCountry());
    }

    if (!isValid) {
      HibernateContextUtils.setHibernateContext(context,
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.decision"
              + ".transitdestinationthirdcountry.not.null}",
          "transitdestinationthirdcountry");
    }

    return isValid;
  }
}
