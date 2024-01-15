package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;
import uk.gov.defra.tracesx.notificationschema.validation.utils.HibernateContextUtils;

public class NotNullTranshipmentThirdCountryValidator implements
    ConstraintValidator<NotNullTranshipmentThirdCountry, Decision> {

  @Override
  public void initialize(NotNullTranshipmentThirdCountry constraintAnnotation) {
    // No action
  }

  @Override
  public boolean isValid(Decision decision, ConstraintValidatorContext context) {
    boolean isValid = true;
    if (decision != null && decision.getDecision() != null
        && DecisionEnum.ACCEPTABLE_FOR_TRANSHIPMENT.equals(decision.getDecision())) {
      isValid = StringUtils.isNotBlank(decision.getTranshipmentThirdCountry());
    }

    if (!isValid) {
      HibernateContextUtils.setHibernateContext(context,
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.decision"
              + ".transhipmentthirdcountry.not.null}",
          "transhipmentthirdcountry");
    }

    return isValid;
  }
}
