package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.UUID;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class CommodityComplement {

  private UUID uniqueComplementID;
  private String commodityID;
  private String commodityDescription;
  private Integer complementID;
  private String complementName;
  private String eppoCode;
  private Boolean isWoodPackaging;
  private String speciesID;
  private String speciesName;
  private String speciesTypeName;
  private String speciesType;
  private String speciesClassName;
  private String speciesClass;
  private String speciesFamilyName;
  private String speciesFamily;
  private String speciesNomination;
  private String speciesCommonName;
}
