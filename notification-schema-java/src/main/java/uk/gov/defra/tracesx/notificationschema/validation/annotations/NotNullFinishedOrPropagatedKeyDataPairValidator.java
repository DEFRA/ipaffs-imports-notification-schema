package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import org.apache.commons.lang3.StringUtils;
import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;

import java.util.Arrays;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotNullFinishedOrPropagatedKeyDataPairValidator implements
    ConstraintValidator<NotNullFinishedOrPropagatedKeyDataPair, Commodities> {

  private static final String COMMODITY_GROUP_KEY = "commodity_group";
  private static final String FINISHED_OR_PROPAGATED_KEY = "finished_or_propagated";
  private static final List<String> APPLICABLE_COMMODITY_GROUPS = Arrays
      .asList("Seed & Tissue Culture", "Plants for Planting");

  @Override
  public boolean isValid(Commodities commodities,
      ConstraintValidatorContext constraintValidatorContext) {
    if (commodities == null || commodities.getComplementParameterSet() == null
        || commodities.getConsignedCountryInChargeGroup() == null
        || commodities.getConsignedCountryInChargeGroup().equals(false)) {
      return true;
    }

    return commodities.getComplementParameterSet().stream()
        .filter(this::hasCommodityGroupPresent)
        .allMatch(this::hasFinishedOrPropagatedPresent);
  }

  private boolean hasCommodityGroupPresent(ComplementParameterSet complementParameterSet) {
    if (complementParameterSet.getKeyDataPair() == null) {
      return false;
    }

    return complementParameterSet.getKeyDataPair().stream()
        .filter(kdp -> kdp.getKey() != null && kdp.getData() != null)
        .anyMatch(kdp -> kdp.getKey().equals(COMMODITY_GROUP_KEY)
            && StringUtils.isNotEmpty(kdp.getData())
            && APPLICABLE_COMMODITY_GROUPS.contains(kdp.getData()));
  }

  private boolean hasFinishedOrPropagatedPresent(ComplementParameterSet complementParameterSet) {
    return complementParameterSet.getKeyDataPair().stream()
        .filter(kdp -> kdp.getKey() != null && kdp.getData() != null)
        .anyMatch(kdp -> kdp.getKey().equals(FINISHED_OR_PROPAGATED_KEY)
            && StringUtils.isNotEmpty(kdp.getData()));
  }
}