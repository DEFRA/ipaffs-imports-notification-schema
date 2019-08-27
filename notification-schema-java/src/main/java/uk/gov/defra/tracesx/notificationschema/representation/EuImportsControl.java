package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ActionFollowingQuarantine;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PlaceOfControl;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateTimeDeserializer;
import uk.gov.defra.tracesx.notificationschema.representation.serialisation.IsoDateTimeSerializer;

import java.time.LocalDateTime;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EuImportsControl {
  @JsonSerialize(using = IsoDateTimeSerializer.class)
  @JsonDeserialize(using = IsoDateTimeDeserializer.class)
  private LocalDateTime dateOfControl;

  private DocumentaryCheck documentaryCheck;
  private Result identityCheck;
  private String physicalCheck;
  private LaboratoryTests laboratoryTests;
  private Result welfareCheck;
  private Infringements infringements;
  private ImpactOfTransportOnAnimals impactOfTransportOnAnimals;
  private ActionFollowingQuarantine actionFollowingQuarantine;
  private OfficialVeterinarian officialVeterinarian;
  private PlaceOfControl placeOfControl;
}
