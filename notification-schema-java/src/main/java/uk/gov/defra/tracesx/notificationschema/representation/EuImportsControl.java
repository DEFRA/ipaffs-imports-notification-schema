package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.ActionFollowingQuarantine;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.PlaceOfControl;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.Result;

import java.time.LocalDateTime;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EuImportsControl {

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
