package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.RetrospectiveCloningProperty;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CommodityComplement {

  private UUID uniqueComplementID;
  @RetrospectiveCloningProperty()
  private String commodityID;
  @RetrospectiveCloningProperty()
  private String commodityDescription;
  @RetrospectiveCloningProperty()
  private Integer complementID;
  @RetrospectiveCloningProperty()
  private String complementName;
  private String eppoCode;
  private Boolean isWoodPackaging;
  @RetrospectiveCloningProperty()
  private String speciesID;
  @RetrospectiveCloningProperty()
  private String speciesName;
  @RetrospectiveCloningProperty()
  private String speciesTypeName;
  @RetrospectiveCloningProperty()
  private String speciesType;
  @RetrospectiveCloningProperty()
  private String speciesClassName;
  @RetrospectiveCloningProperty()
  private String speciesClass;
  @RetrospectiveCloningProperty()
  private String speciesFamilyName;
  @RetrospectiveCloningProperty()
  private String speciesFamily;
  @RetrospectiveCloningProperty()
  private String speciesNomination;
  private String speciesCommonName;
  private Boolean isCdsMatched;
}
