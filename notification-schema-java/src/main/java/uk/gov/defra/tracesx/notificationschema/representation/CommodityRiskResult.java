package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.HmiDecision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhsiClassification;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhsiDecision;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PhsiRuleType;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.RiskDecision;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CommodityRiskResult {

  private RiskDecision riskDecision;
  private HmiDecision hmiDecision;
  private PhsiDecision phsiDecision;
  private PhsiClassification phsiClassification;
  private Phsi phsi;
  private UUID uniqueId;
  private String eppoCode;
  private String variety;
  private Boolean isWoody;
  private String indoorOutdoor;
  private String propagation;
  private PhsiRuleType phsiRuleType;
}
