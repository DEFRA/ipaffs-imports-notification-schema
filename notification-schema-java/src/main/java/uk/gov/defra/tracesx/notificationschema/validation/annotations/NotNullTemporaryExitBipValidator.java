package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.Decision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.DecisionEnum;
import uk.gov.defra.tracesx.notificationschema.validation.utils.HibernateContextUtils;

public class NotNullTemporaryExitBipValidator implements
    ConstraintValidator<NotNullTemporaryExitBip, Decision> {

  @Override
  public void initialize(NotNullTemporaryExitBip constraintAnnotation) {
    // No action
  }

  @Override
  public boolean isValid(Decision decision, ConstraintValidatorContext context) {
    boolean isValid = true;
    if (decision != null && decision.getDecision() != null
        && DecisionEnum.ACCEPTABLE_FOR_TEMPORARY_IMPORT.equals(decision.getDecision())) {
      isValid = StringUtils.isNotBlank(decision.getTemporaryExitBip());
    }

    if (!isValid) {
      HibernateContextUtils.setHibernateContext(context,
          "{uk.gov.defra.tracesx.notificationschema.representation.parttwo.decision"
              + ".temporaryexitbip.not.null}",
          "temporaryexitbip");
    }

    return isValid;
  }
}
