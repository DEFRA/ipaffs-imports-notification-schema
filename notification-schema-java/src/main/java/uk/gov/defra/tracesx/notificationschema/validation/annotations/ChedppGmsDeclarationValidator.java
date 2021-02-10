package uk.gov.defra.tracesx.notificationschema.validation.annotations;

import uk.gov.defra.tracesx.notificationschema.representation.Commodities;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSet;
import uk.gov.defra.tracesx.notificationschema.representation.ComplementParameterSetKeyDataPair;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ChedppGmsDeclarationValidator implements
    ConstraintValidator<ChedppGmsDeclaration, Commodities> {

  private static final String REGULATORY_AUTHORITY = "regulatory_authority";
  private static final String MARKETING_STANDARD = "marketing_standard";
  private static final String HMI = "HMI";
  private static final String GMS = "GMS";

  @Override
  public boolean isValid(Commodities commodities,
      ConstraintValidatorContext constraintValidatorContext) {
    if (commodities == null || commodities.getComplementParameterSet() == null) {
      return true;
    }

    if (hmiGmsCommodityPresent(commodities.getComplementParameterSet())) {
      return commodities.getGmsDeclarationAccepted() != null && commodities
          .getGmsDeclarationAccepted().equals(Boolean.TRUE);
    }

    return true;
  }

  private boolean hmiGmsCommodityPresent(List<ComplementParameterSet> complementParameterSets) {
    return complementParameterSets.stream()
        .map(ComplementParameterSet::getKeyDataPair)
        .anyMatch(this::isHmiGms);
  }

  private boolean isHmiGms(List<ComplementParameterSetKeyDataPair> keyDataPairList) {
    Map<String, String> keyDataPairMap = keyDataPairList.stream()
        .filter(kdp -> kdp.getKey() != null && kdp.getData() != null)
        .collect(Collectors.toMap(ComplementParameterSetKeyDataPair::getKey,
            ComplementParameterSetKeyDataPair::getData));

    return Objects.equals(keyDataPairMap.get(REGULATORY_AUTHORITY), HMI)
        && Objects.equals(keyDataPairMap.get(MARKETING_STANDARD), GMS);
  }
}