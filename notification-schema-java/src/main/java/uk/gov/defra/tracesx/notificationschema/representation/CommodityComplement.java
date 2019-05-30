package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
@EqualsAndHashCode
public class CommodityComplement {

  private String commodityID;
  private String commodityDescription;
  private Integer complementID;
  private String speciesID;
  private String speciesName;
  private String speciesTypeName;
  private String speciesType;
  private String speciesClassName;
  private String speciesClass;
  private String speciesFamilyName;
  private String speciesFamily;
  private String speciesNomination;
}
