package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.Data;
import lombok.extern.jackson.Jacksonized;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@Jacksonized
public class CommonUserCharge {

  private Boolean wasSentToTradeCharge;
}
