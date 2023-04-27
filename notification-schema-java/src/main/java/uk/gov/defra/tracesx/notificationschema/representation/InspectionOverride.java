package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.InspectionRequired;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.OverrideReason;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoOffsetDateTimeSerializer;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class InspectionOverride {

  private InspectionRequired originalDecision;

  @JsonSerialize(using = IsoOffsetDateTimeSerializer.class)
  @JsonDeserialize(using = IsoOffsetDateTimeDeserializer.class)
  private LocalDateTime overriddenOn;

  private UserInformation overriddenBy;
  private OverrideReason overrideReason;
  private String overrideReasonOther;

}
