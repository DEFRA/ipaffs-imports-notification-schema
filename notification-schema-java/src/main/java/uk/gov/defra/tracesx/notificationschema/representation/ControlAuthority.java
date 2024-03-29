package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.IUUOption;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ControlAuthority {

  private OfficialVeterinarian officialVeterinarian;
  private String customsReferenceNo;
  private Boolean containerResealed;
  private String newSealNumber;
  private String iuuFishingReference;
  private Boolean iuuCheckRequired;
  private IUUOption iuuOption;
}
