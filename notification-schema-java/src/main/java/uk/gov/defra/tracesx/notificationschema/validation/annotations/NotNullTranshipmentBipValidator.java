package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;
import uk.gov.defra.tracesx.notificationschema.validation.utils.HibernateContextUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullTranshipmentBipValidator implements
    ConstraintValidator<NotNullTranshipmentBip, Decision> {

  @Override
  public void initialize(NotNullTranshipmentBip constraintAnnotation) {
    // No action
  }

  @Override
  public boolean isValid(Decision decision, ConstraintValidatorContext context) {
    boolean isValid = true;
    if (decision != null && decision.getDecision() != null
        && DecisionEnum.ACCEPTABLE_FOR_TRANSHIPMENT.equals(decision.getDecision())) {
      isValid = StringUtils.isNotBlank(decision.getTranshipmentBip());
    }

    if (!isValid) {
      HibernateContextUtils.setHibernateContext(context,
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.decision"
              + ".transhipmentbip.not.null}",
          "transhipmentbip");
    }

    return isValid;
  }
}