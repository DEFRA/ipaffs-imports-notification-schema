package uk.gov.defra.tracesx.notificationschema.representation;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.AnimalCertification;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.CommodityIntention;
import uk.gov.defra.tracesx.notificationschema.representation.enumeration.CommodityTemperature;
import uk.gov.defra.tracesx.notificationschema.validation.annotations.MinCommoditiesGrossWeight;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCedOrCvedpFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationCvedaFieldValidation;
import uk.gov.defra.tracesx.notificationschema.validation.groups.NotificationFieldValidation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Builder
@Data
@JsonInclude(Include.NON_EMPTY)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@MinCommoditiesGrossWeight(
    groups = NotificationCedOrCvedpFieldValidation.class,
    message =
        "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
            + ".totalgrossweight.min.message}")
public class Commodities {

  @NotNull(
      groups = NotificationCedOrCvedpFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".totalgrossweight.not.null}")
  private BigDecimal totalGrossWeight;

  @NotNull(
      groups = NotificationCedOrCvedpFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".totalnetweight.not.null}")
  private BigDecimal totalNetWeight;

  private Integer numberOfPackages;

  @NotNull(
      groups = NotificationCedOrCvedpFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".temperature.not.null}")
  private CommodityTemperature temperature = null;

  @NotNull(
      groups = NotificationCvedaFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".numberofanimals.not.null}")
  @Min(
      value = 1,
      groups = NotificationCvedaFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".numberofanimals.min.message}")
  private Integer numberOfAnimals = null;

  private List<CommodityComplement> commodityComplement = null;

  @Valid
  private List<ComplementParameterSet> complementParameterSet = null;

  private Boolean includeNonAblactedAnimals = null;

  @NotNull(
      groups = NotificationFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".countryoforigin.not.null}")
  private String countryOfOrigin = null;

  private String regionOfOrigin = null;

  @NotNull(
      groups = NotificationCedOrCvedpFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".consignedcountry.not.null}")
  private String consignedCountry = null;

  @NotNull(
      groups = NotificationCvedaFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".animalscertifiedas.not.null}")
  private AnimalCertification animalsCertifiedAs = null;

  private CommodityIntention commodityIntendedFor = null;

  @NotNull(
      groups = NotificationCedOrCvedpFieldValidation.class,
      message =
          "{uk.gov.defra.tracesx.notificationschema.representation.partone.commodities"
              + ".totalgrossvolume.not.null}")
  private BigDecimal totalGrossVolume;

  private String totalGrossVolumeUnit;

  public Commodities addCommodityComplementItem(CommodityComplement commodityComplementItem) {
    if (this.commodityComplement == null) {
      this.commodityComplement = new ArrayList<>();
    }
    this.commodityComplement.add(commodityComplementItem);
    return this;
  }

  public Commodities addComplementParameterSetItem(
      ComplementParameterSet complementParameterSetItem) {
    if (this.complementParameterSet == null) {
      this.complementParameterSet = new ArrayList<>();
    }
    this.complementParameterSet.add(complementParameterSetItem);
    return this;
  }
}
