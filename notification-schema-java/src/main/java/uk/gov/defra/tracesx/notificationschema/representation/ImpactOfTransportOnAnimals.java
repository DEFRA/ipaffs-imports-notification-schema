package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.AnimalsUnit;

@Builder
@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ImpactOfTransportOnAnimals {

  private Integer numberOfDeadAnimals = null;
  private AnimalsUnit numberOfDeadAnimalsUnit = null;
  private Integer numberOfUnfitAnimals = null;
  private AnimalsUnit numberOfUnfitAnimalsUnit = null;
  private Integer numberOfBirthOrAbortion = null;
}
