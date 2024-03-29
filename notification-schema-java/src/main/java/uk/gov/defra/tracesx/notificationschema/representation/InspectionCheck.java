package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.CheckStatus;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.CheckType;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class InspectionCheck {

  private CheckType type;
  private CheckStatus status;
  private String reason;
  private String otherReason;
  private Boolean isSelectedForChecks;
  private Boolean hasChecksComplete;
}
